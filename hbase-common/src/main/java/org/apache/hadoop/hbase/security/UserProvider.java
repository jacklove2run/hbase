/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.security;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.CommonConfigurationKeys;
import org.apache.hadoop.hbase.BaseConfigurable;
import org.apache.hadoop.security.Groups;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.hadoop.util.ReflectionUtils;
import org.apache.yetus.audience.InterfaceAudience;

import org.apache.hbase.thirdparty.com.google.common.cache.CacheBuilder;
import org.apache.hbase.thirdparty.com.google.common.cache.CacheLoader;
import org.apache.hbase.thirdparty.com.google.common.cache.LoadingCache;
import org.apache.hbase.thirdparty.com.google.common.util.concurrent.ListenableFuture;
import org.apache.hbase.thirdparty.com.google.common.util.concurrent.ListeningExecutorService;
import org.apache.hbase.thirdparty.com.google.common.util.concurrent.MoreExecutors;
import org.apache.hbase.thirdparty.com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * Provide an instance of a user. Allows custom {@link User} creation.
 */
@InterfaceAudience.Private
public class UserProvider extends BaseConfigurable {

  private static final String USER_PROVIDER_CONF_KEY = "hbase.client.userprovider.class";

  private static final String HBASE_SECURITY_AUTHENTICATION_KEY = "hbase.security.authentication";
  private static final String HBASE_SECURITY_BASIC_AUTH_KEY = "hbase.security.basic.auth";

  private static final String HBASE_CLIENT_USERNAME_KEY = "hbase.client.username";

  private static final String HBASE_CLIENT_PASSWORD_KEY = "hbase.client.password";
  private static final ListeningExecutorService executor = MoreExecutors.listeningDecorator(
      Executors.newScheduledThreadPool(
          1,
          new ThreadFactoryBuilder().setDaemon(true).setNameFormat("group-cache-%d").build()));

  private LoadingCache<String, String[]> groupCache = null;

  static Groups groups = Groups.getUserToGroupsMappingService();

  @Override
  public void setConf(final Configuration conf) {
    super.setConf(conf);

    synchronized (UserProvider.class) {
      if (!(groups instanceof User.TestingGroups)) {
        groups = Groups.getUserToGroupsMappingService(conf);
      }
    }

    long cacheTimeout =
        getConf().getLong(CommonConfigurationKeys.HADOOP_SECURITY_GROUPS_CACHE_SECS,
            CommonConfigurationKeys.HADOOP_SECURITY_GROUPS_CACHE_SECS_DEFAULT) * 1000;

    this.groupCache = CacheBuilder.newBuilder()
        // This is the same timeout that hadoop uses. So we'll follow suit.
        .refreshAfterWrite(cacheTimeout, TimeUnit.MILLISECONDS)
        .expireAfterWrite(10 * cacheTimeout, TimeUnit.MILLISECONDS)
            // Set concurrency level equal to the default number of handlers that
            // the simple handler spins up.
        .concurrencyLevel(20)
            // create the loader
            // This just delegates to UGI.
        .build(new CacheLoader<String, String[]>() {

          // Since UGI's don't hash based on the user id
          // The cache needs to be keyed on the same thing that Hadoop's Groups class
          // uses. So this cache uses shortname.
          @Override
          public String[] load(String ugi) throws Exception {
            return getGroupStrings(ugi);
          }

          private String[] getGroupStrings(String ugi) {
            try {
              Set<String> result = new LinkedHashSet<>(groups.getGroups(ugi));
              return result.toArray(new String[result.size()]);
            } catch (Exception e) {
              return new String[0];
            }
          }

          // Provide the reload function that uses the executor thread.
          @Override
          public ListenableFuture<String[]> reload(final String k, String[] oldValue)
              throws Exception {

            return executor.submit(new Callable<String[]>() {
              @Override
              public String[] call() throws Exception {
                return getGroupStrings(k);
              }
            });
          }
        });
  }

  /**
   * Instantiate the {@link UserProvider} specified in the configuration and set the passed
   * configuration via {@link UserProvider#setConf(Configuration)}
   * @param conf to read and set on the created {@link UserProvider}
   * @return a {@link UserProvider} ready for use.
   */
  public static UserProvider instantiate(Configuration conf) {
    Class<? extends UserProvider> clazz =
        conf.getClass(USER_PROVIDER_CONF_KEY, UserProvider.class, UserProvider.class);
    return ReflectionUtils.newInstance(clazz, conf);
  }

  /**
   * Set the {@link UserProvider} in the given configuration that should be instantiated
   * @param conf to update
   * @param provider class of the provider to set
   */
  public static void setUserProviderForTesting(Configuration conf,
      Class<? extends UserProvider> provider) {
    conf.set(USER_PROVIDER_CONF_KEY, provider.getName());
  }

  /**
   * @return the userName for the current logged-in user.
   * @throws IOException if the underlying user cannot be obtained
   */
  public String getCurrentUserName() throws IOException {
    User user = getCurrent();
    return user == null ? null : user.getName();
  }

  /**
   * @return <tt>true</tt> if security is enabled, <tt>false</tt> otherwise
   */
  public boolean isHBaseSecurityEnabled() {
    return User.isHBaseSecurityEnabled(this.getConf());
  }

  /**
   * @return whether or not Kerberos authentication is configured for Hadoop. For non-secure Hadoop,
   *         this always returns <code>false</code>. For secure Hadoop, it will return the value
   *         from {@code UserGroupInformation.isSecurityEnabled()}.
   */
  public boolean isHadoopSecurityEnabled() {
    return User.isSecurityEnabled();
  }

  /**
   * @return the current user within the current execution context
   * @throws IOException if the user cannot be loaded
   */
  public User getCurrent() throws IOException {
    return User.getCurrent();
  }

  public User getCurrent(Configuration conf) throws IOException {
    if (!conf.getBoolean(HBASE_SECURITY_BASIC_AUTH_KEY, false)
            || !conf.get(HBASE_SECURITY_AUTHENTICATION_KEY, "").equals("simple")
            || conf.get(HBASE_CLIENT_USERNAME_KEY, "").isEmpty()
            || conf.get(HBASE_CLIENT_PASSWORD_KEY, "").isEmpty()) {
      return User.getCurrent();
    }
    return User.getCurrentByName(conf.get(HBASE_CLIENT_USERNAME_KEY));
  }

  /**
   * @return the current user with the username
   * @throws IOException if the user cannot be loaded
   */
  public User getCurrentByName(String username) throws IOException {
    return User.getCurrentByName(username);
  }

  /**
   * Wraps an underlying {@code UserGroupInformation} instance.
   * @param ugi The base Hadoop user
   * @return User
   */
  public User create(UserGroupInformation ugi) {
    if (ugi == null) {
      return null;
    }
    return new User.SecureHadoopUser(ugi, groupCache);
  }

  /**
   * Log in the current process using the given configuration keys for the credential file and login
   * principal.
   * <p>
   * <strong>This is only applicable when running on secure Hadoop</strong> -- see
   * org.apache.hadoop.security.SecurityUtil#login(Configuration,String,String,String). On regular
   * Hadoop (without security features), this will safely be ignored.
   * </p>
   * @param fileConfKey Property key used to configure path to the credential file
   * @param principalConfKey Property key used to configure login principal
   * @param localhost Current hostname to use in any credentials
   * @throws IOException underlying exception from SecurityUtil.login() call
   */
  public void login(String fileConfKey, String principalConfKey, String localhost)
      throws IOException {
    User.login(getConf(), fileConfKey, principalConfKey, localhost);
  }
}
