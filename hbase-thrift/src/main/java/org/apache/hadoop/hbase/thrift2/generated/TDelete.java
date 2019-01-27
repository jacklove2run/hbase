/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hadoop.hbase.thrift2.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
/**
 * Used to perform Delete operations on a single row.
 * 
 * The scope can be further narrowed down by specifying a list of
 * columns or column families as TColumns.
 * 
 * Specifying only a family in a TColumn will delete the whole family.
 * If a timestamp is specified all versions with a timestamp less than
 * or equal to this will be deleted. If no timestamp is specified the
 * current time will be used.
 * 
 * Specifying a family and a column qualifier in a TColumn will delete only
 * this qualifier. If a timestamp is specified only versions equal
 * to this timestamp will be deleted. If no timestamp is specified the
 * most recent version will be deleted.  To delete all previous versions,
 * specify the DELETE_COLUMNS TDeleteType.
 * 
 * The top level timestamp is only used if a complete row should be deleted
 * (i.e. no columns are passed) and if it is specified it works the same way
 * as if you had added a TColumn for every column family and this timestamp
 * (i.e. all versions older than or equal in all column families will be deleted)
 * 
 * You can specify how this Delete should be written to the write-ahead Log (WAL)
 * by changing the durability. If you don't provide durability, it defaults to
 * column family's default setting for durability.
 */
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-01-27")
public class TDelete implements org.apache.thrift.TBase<TDelete, TDelete._Fields>, java.io.Serializable, Cloneable, Comparable<TDelete> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TDelete");

  private static final org.apache.thrift.protocol.TField ROW_FIELD_DESC = new org.apache.thrift.protocol.TField("row", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField COLUMNS_FIELD_DESC = new org.apache.thrift.protocol.TField("columns", org.apache.thrift.protocol.TType.LIST, (short)2);
  private static final org.apache.thrift.protocol.TField TIMESTAMP_FIELD_DESC = new org.apache.thrift.protocol.TField("timestamp", org.apache.thrift.protocol.TType.I64, (short)3);
  private static final org.apache.thrift.protocol.TField DELETE_TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("deleteType", org.apache.thrift.protocol.TType.I32, (short)4);
  private static final org.apache.thrift.protocol.TField ATTRIBUTES_FIELD_DESC = new org.apache.thrift.protocol.TField("attributes", org.apache.thrift.protocol.TType.MAP, (short)6);
  private static final org.apache.thrift.protocol.TField DURABILITY_FIELD_DESC = new org.apache.thrift.protocol.TField("durability", org.apache.thrift.protocol.TType.I32, (short)7);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TDeleteStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TDeleteTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer row; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<TColumn> columns; // optional
  public long timestamp; // optional
  /**
   * 
   * @see TDeleteType
   */
  public @org.apache.thrift.annotation.Nullable TDeleteType deleteType; // optional
  public @org.apache.thrift.annotation.Nullable java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> attributes; // optional
  /**
   * 
   * @see TDurability
   */
  public @org.apache.thrift.annotation.Nullable TDurability durability; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROW((short)1, "row"),
    COLUMNS((short)2, "columns"),
    TIMESTAMP((short)3, "timestamp"),
    /**
     * 
     * @see TDeleteType
     */
    DELETE_TYPE((short)4, "deleteType"),
    ATTRIBUTES((short)6, "attributes"),
    /**
     * 
     * @see TDurability
     */
    DURABILITY((short)7, "durability");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ROW
          return ROW;
        case 2: // COLUMNS
          return COLUMNS;
        case 3: // TIMESTAMP
          return TIMESTAMP;
        case 4: // DELETE_TYPE
          return DELETE_TYPE;
        case 6: // ATTRIBUTES
          return ATTRIBUTES;
        case 7: // DURABILITY
          return DURABILITY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __TIMESTAMP_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.COLUMNS,_Fields.TIMESTAMP,_Fields.DELETE_TYPE,_Fields.ATTRIBUTES,_Fields.DURABILITY};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROW, new org.apache.thrift.meta_data.FieldMetaData("row", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING        , true)));
    tmpMap.put(_Fields.COLUMNS, new org.apache.thrift.meta_data.FieldMetaData("columns", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TColumn.class))));
    tmpMap.put(_Fields.TIMESTAMP, new org.apache.thrift.meta_data.FieldMetaData("timestamp", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.DELETE_TYPE, new org.apache.thrift.meta_data.FieldMetaData("deleteType", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TDeleteType.class)));
    tmpMap.put(_Fields.ATTRIBUTES, new org.apache.thrift.meta_data.FieldMetaData("attributes", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING            , true))));
    tmpMap.put(_Fields.DURABILITY, new org.apache.thrift.meta_data.FieldMetaData("durability", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, TDurability.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TDelete.class, metaDataMap);
  }

  public TDelete() {
    this.deleteType = org.apache.hadoop.hbase.thrift2.generated.TDeleteType.DELETE_COLUMNS;

  }

  public TDelete(
    java.nio.ByteBuffer row)
  {
    this();
    this.row = org.apache.thrift.TBaseHelper.copyBinary(row);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TDelete(TDelete other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.isSetRow()) {
      this.row = org.apache.thrift.TBaseHelper.copyBinary(other.row);
    }
    if (other.isSetColumns()) {
      java.util.List<TColumn> __this__columns = new java.util.ArrayList<TColumn>(other.columns.size());
      for (TColumn other_element : other.columns) {
        __this__columns.add(new TColumn(other_element));
      }
      this.columns = __this__columns;
    }
    this.timestamp = other.timestamp;
    if (other.isSetDeleteType()) {
      this.deleteType = other.deleteType;
    }
    if (other.isSetAttributes()) {
      java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> __this__attributes = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(other.attributes);
      this.attributes = __this__attributes;
    }
    if (other.isSetDurability()) {
      this.durability = other.durability;
    }
  }

  public TDelete deepCopy() {
    return new TDelete(this);
  }

  @Override
  public void clear() {
    this.row = null;
    this.columns = null;
    setTimestampIsSet(false);
    this.timestamp = 0;
    this.deleteType = org.apache.hadoop.hbase.thrift2.generated.TDeleteType.DELETE_COLUMNS;

    this.attributes = null;
    this.durability = null;
  }

  public byte[] getRow() {
    setRow(org.apache.thrift.TBaseHelper.rightSize(row));
    return row == null ? null : row.array();
  }

  public java.nio.ByteBuffer bufferForRow() {
    return org.apache.thrift.TBaseHelper.copyBinary(row);
  }

  public TDelete setRow(byte[] row) {
    this.row = row == null ? (java.nio.ByteBuffer)null   : java.nio.ByteBuffer.wrap(row.clone());
    return this;
  }

  public TDelete setRow(@org.apache.thrift.annotation.Nullable java.nio.ByteBuffer row) {
    this.row = org.apache.thrift.TBaseHelper.copyBinary(row);
    return this;
  }

  public void unsetRow() {
    this.row = null;
  }

  /** Returns true if field row is set (has been assigned a value) and false otherwise */
  public boolean isSetRow() {
    return this.row != null;
  }

  public void setRowIsSet(boolean value) {
    if (!value) {
      this.row = null;
    }
  }

  public int getColumnsSize() {
    return (this.columns == null) ? 0 : this.columns.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TColumn> getColumnsIterator() {
    return (this.columns == null) ? null : this.columns.iterator();
  }

  public void addToColumns(TColumn elem) {
    if (this.columns == null) {
      this.columns = new java.util.ArrayList<TColumn>();
    }
    this.columns.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TColumn> getColumns() {
    return this.columns;
  }

  public TDelete setColumns(@org.apache.thrift.annotation.Nullable java.util.List<TColumn> columns) {
    this.columns = columns;
    return this;
  }

  public void unsetColumns() {
    this.columns = null;
  }

  /** Returns true if field columns is set (has been assigned a value) and false otherwise */
  public boolean isSetColumns() {
    return this.columns != null;
  }

  public void setColumnsIsSet(boolean value) {
    if (!value) {
      this.columns = null;
    }
  }

  public long getTimestamp() {
    return this.timestamp;
  }

  public TDelete setTimestamp(long timestamp) {
    this.timestamp = timestamp;
    setTimestampIsSet(true);
    return this;
  }

  public void unsetTimestamp() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  /** Returns true if field timestamp is set (has been assigned a value) and false otherwise */
  public boolean isSetTimestamp() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TIMESTAMP_ISSET_ID);
  }

  public void setTimestampIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TIMESTAMP_ISSET_ID, value);
  }

  /**
   * 
   * @see TDeleteType
   */
  @org.apache.thrift.annotation.Nullable
  public TDeleteType getDeleteType() {
    return this.deleteType;
  }

  /**
   * 
   * @see TDeleteType
   */
  public TDelete setDeleteType(@org.apache.thrift.annotation.Nullable TDeleteType deleteType) {
    this.deleteType = deleteType;
    return this;
  }

  public void unsetDeleteType() {
    this.deleteType = null;
  }

  /** Returns true if field deleteType is set (has been assigned a value) and false otherwise */
  public boolean isSetDeleteType() {
    return this.deleteType != null;
  }

  public void setDeleteTypeIsSet(boolean value) {
    if (!value) {
      this.deleteType = null;
    }
  }

  public int getAttributesSize() {
    return (this.attributes == null) ? 0 : this.attributes.size();
  }

  public void putToAttributes(java.nio.ByteBuffer key, java.nio.ByteBuffer val) {
    if (this.attributes == null) {
      this.attributes = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>();
    }
    this.attributes.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> getAttributes() {
    return this.attributes;
  }

  public TDelete setAttributes(@org.apache.thrift.annotation.Nullable java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer> attributes) {
    this.attributes = attributes;
    return this;
  }

  public void unsetAttributes() {
    this.attributes = null;
  }

  /** Returns true if field attributes is set (has been assigned a value) and false otherwise */
  public boolean isSetAttributes() {
    return this.attributes != null;
  }

  public void setAttributesIsSet(boolean value) {
    if (!value) {
      this.attributes = null;
    }
  }

  /**
   * 
   * @see TDurability
   */
  @org.apache.thrift.annotation.Nullable
  public TDurability getDurability() {
    return this.durability;
  }

  /**
   * 
   * @see TDurability
   */
  public TDelete setDurability(@org.apache.thrift.annotation.Nullable TDurability durability) {
    this.durability = durability;
    return this;
  }

  public void unsetDurability() {
    this.durability = null;
  }

  /** Returns true if field durability is set (has been assigned a value) and false otherwise */
  public boolean isSetDurability() {
    return this.durability != null;
  }

  public void setDurabilityIsSet(boolean value) {
    if (!value) {
      this.durability = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ROW:
      if (value == null) {
        unsetRow();
      } else {
        if (value instanceof byte[]) {
          setRow((byte[])value);
        } else {
          setRow((java.nio.ByteBuffer)value);
        }
      }
      break;

    case COLUMNS:
      if (value == null) {
        unsetColumns();
      } else {
        setColumns((java.util.List<TColumn>)value);
      }
      break;

    case TIMESTAMP:
      if (value == null) {
        unsetTimestamp();
      } else {
        setTimestamp((java.lang.Long)value);
      }
      break;

    case DELETE_TYPE:
      if (value == null) {
        unsetDeleteType();
      } else {
        setDeleteType((TDeleteType)value);
      }
      break;

    case ATTRIBUTES:
      if (value == null) {
        unsetAttributes();
      } else {
        setAttributes((java.util.Map<java.nio.ByteBuffer,java.nio.ByteBuffer>)value);
      }
      break;

    case DURABILITY:
      if (value == null) {
        unsetDurability();
      } else {
        setDurability((TDurability)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ROW:
      return getRow();

    case COLUMNS:
      return getColumns();

    case TIMESTAMP:
      return getTimestamp();

    case DELETE_TYPE:
      return getDeleteType();

    case ATTRIBUTES:
      return getAttributes();

    case DURABILITY:
      return getDurability();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ROW:
      return isSetRow();
    case COLUMNS:
      return isSetColumns();
    case TIMESTAMP:
      return isSetTimestamp();
    case DELETE_TYPE:
      return isSetDeleteType();
    case ATTRIBUTES:
      return isSetAttributes();
    case DURABILITY:
      return isSetDurability();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TDelete)
      return this.equals((TDelete)that);
    return false;
  }

  public boolean equals(TDelete that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_row = true && this.isSetRow();
    boolean that_present_row = true && that.isSetRow();
    if (this_present_row || that_present_row) {
      if (!(this_present_row && that_present_row))
        return false;
      if (!this.row.equals(that.row))
        return false;
    }

    boolean this_present_columns = true && this.isSetColumns();
    boolean that_present_columns = true && that.isSetColumns();
    if (this_present_columns || that_present_columns) {
      if (!(this_present_columns && that_present_columns))
        return false;
      if (!this.columns.equals(that.columns))
        return false;
    }

    boolean this_present_timestamp = true && this.isSetTimestamp();
    boolean that_present_timestamp = true && that.isSetTimestamp();
    if (this_present_timestamp || that_present_timestamp) {
      if (!(this_present_timestamp && that_present_timestamp))
        return false;
      if (this.timestamp != that.timestamp)
        return false;
    }

    boolean this_present_deleteType = true && this.isSetDeleteType();
    boolean that_present_deleteType = true && that.isSetDeleteType();
    if (this_present_deleteType || that_present_deleteType) {
      if (!(this_present_deleteType && that_present_deleteType))
        return false;
      if (!this.deleteType.equals(that.deleteType))
        return false;
    }

    boolean this_present_attributes = true && this.isSetAttributes();
    boolean that_present_attributes = true && that.isSetAttributes();
    if (this_present_attributes || that_present_attributes) {
      if (!(this_present_attributes && that_present_attributes))
        return false;
      if (!this.attributes.equals(that.attributes))
        return false;
    }

    boolean this_present_durability = true && this.isSetDurability();
    boolean that_present_durability = true && that.isSetDurability();
    if (this_present_durability || that_present_durability) {
      if (!(this_present_durability && that_present_durability))
        return false;
      if (!this.durability.equals(that.durability))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetRow()) ? 131071 : 524287);
    if (isSetRow())
      hashCode = hashCode * 8191 + row.hashCode();

    hashCode = hashCode * 8191 + ((isSetColumns()) ? 131071 : 524287);
    if (isSetColumns())
      hashCode = hashCode * 8191 + columns.hashCode();

    hashCode = hashCode * 8191 + ((isSetTimestamp()) ? 131071 : 524287);
    if (isSetTimestamp())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(timestamp);

    hashCode = hashCode * 8191 + ((isSetDeleteType()) ? 131071 : 524287);
    if (isSetDeleteType())
      hashCode = hashCode * 8191 + deleteType.getValue();

    hashCode = hashCode * 8191 + ((isSetAttributes()) ? 131071 : 524287);
    if (isSetAttributes())
      hashCode = hashCode * 8191 + attributes.hashCode();

    hashCode = hashCode * 8191 + ((isSetDurability()) ? 131071 : 524287);
    if (isSetDurability())
      hashCode = hashCode * 8191 + durability.getValue();

    return hashCode;
  }

  @Override
  public int compareTo(TDelete other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetRow()).compareTo(other.isSetRow());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRow()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.row, other.row);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetColumns()).compareTo(other.isSetColumns());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetColumns()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.columns, other.columns);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetTimestamp()).compareTo(other.isSetTimestamp());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTimestamp()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.timestamp, other.timestamp);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDeleteType()).compareTo(other.isSetDeleteType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDeleteType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.deleteType, other.deleteType);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetAttributes()).compareTo(other.isSetAttributes());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetAttributes()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attributes, other.attributes);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetDurability()).compareTo(other.isSetDurability());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetDurability()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.durability, other.durability);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TDelete(");
    boolean first = true;

    sb.append("row:");
    if (this.row == null) {
      sb.append("null");
    } else {
      org.apache.thrift.TBaseHelper.toString(this.row, sb);
    }
    first = false;
    if (isSetColumns()) {
      if (!first) sb.append(", ");
      sb.append("columns:");
      if (this.columns == null) {
        sb.append("null");
      } else {
        sb.append(this.columns);
      }
      first = false;
    }
    if (isSetTimestamp()) {
      if (!first) sb.append(", ");
      sb.append("timestamp:");
      sb.append(this.timestamp);
      first = false;
    }
    if (isSetDeleteType()) {
      if (!first) sb.append(", ");
      sb.append("deleteType:");
      if (this.deleteType == null) {
        sb.append("null");
      } else {
        sb.append(this.deleteType);
      }
      first = false;
    }
    if (isSetAttributes()) {
      if (!first) sb.append(", ");
      sb.append("attributes:");
      if (this.attributes == null) {
        sb.append("null");
      } else {
        sb.append(this.attributes);
      }
      first = false;
    }
    if (isSetDurability()) {
      if (!first) sb.append(", ");
      sb.append("durability:");
      if (this.durability == null) {
        sb.append("null");
      } else {
        sb.append(this.durability);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (row == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'row' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TDeleteStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TDeleteStandardScheme getScheme() {
      return new TDeleteStandardScheme();
    }
  }

  private static class TDeleteStandardScheme extends org.apache.thrift.scheme.StandardScheme<TDelete> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TDelete struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROW
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.row = iprot.readBinary();
              struct.setRowIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // COLUMNS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list52 = iprot.readListBegin();
                struct.columns = new java.util.ArrayList<TColumn>(_list52.size);
                @org.apache.thrift.annotation.Nullable TColumn _elem53;
                for (int _i54 = 0; _i54 < _list52.size; ++_i54)
                {
                  _elem53 = new TColumn();
                  _elem53.read(iprot);
                  struct.columns.add(_elem53);
                }
                iprot.readListEnd();
              }
              struct.setColumnsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TIMESTAMP
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.timestamp = iprot.readI64();
              struct.setTimestampIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // DELETE_TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.deleteType = org.apache.hadoop.hbase.thrift2.generated.TDeleteType.findByValue(iprot.readI32());
              struct.setDeleteTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // ATTRIBUTES
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map55 = iprot.readMapBegin();
                struct.attributes = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(2*_map55.size);
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _key56;
                @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _val57;
                for (int _i58 = 0; _i58 < _map55.size; ++_i58)
                {
                  _key56 = iprot.readBinary();
                  _val57 = iprot.readBinary();
                  struct.attributes.put(_key56, _val57);
                }
                iprot.readMapEnd();
              }
              struct.setAttributesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 7: // DURABILITY
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.durability = org.apache.hadoop.hbase.thrift2.generated.TDurability.findByValue(iprot.readI32());
              struct.setDurabilityIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TDelete struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.row != null) {
        oprot.writeFieldBegin(ROW_FIELD_DESC);
        oprot.writeBinary(struct.row);
        oprot.writeFieldEnd();
      }
      if (struct.columns != null) {
        if (struct.isSetColumns()) {
          oprot.writeFieldBegin(COLUMNS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.columns.size()));
            for (TColumn _iter59 : struct.columns)
            {
              _iter59.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.isSetTimestamp()) {
        oprot.writeFieldBegin(TIMESTAMP_FIELD_DESC);
        oprot.writeI64(struct.timestamp);
        oprot.writeFieldEnd();
      }
      if (struct.deleteType != null) {
        if (struct.isSetDeleteType()) {
          oprot.writeFieldBegin(DELETE_TYPE_FIELD_DESC);
          oprot.writeI32(struct.deleteType.getValue());
          oprot.writeFieldEnd();
        }
      }
      if (struct.attributes != null) {
        if (struct.isSetAttributes()) {
          oprot.writeFieldBegin(ATTRIBUTES_FIELD_DESC);
          {
            oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, struct.attributes.size()));
            for (java.util.Map.Entry<java.nio.ByteBuffer, java.nio.ByteBuffer> _iter60 : struct.attributes.entrySet())
            {
              oprot.writeBinary(_iter60.getKey());
              oprot.writeBinary(_iter60.getValue());
            }
            oprot.writeMapEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.durability != null) {
        if (struct.isSetDurability()) {
          oprot.writeFieldBegin(DURABILITY_FIELD_DESC);
          oprot.writeI32(struct.durability.getValue());
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TDeleteTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TDeleteTupleScheme getScheme() {
      return new TDeleteTupleScheme();
    }
  }

  private static class TDeleteTupleScheme extends org.apache.thrift.scheme.TupleScheme<TDelete> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TDelete struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeBinary(struct.row);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetColumns()) {
        optionals.set(0);
      }
      if (struct.isSetTimestamp()) {
        optionals.set(1);
      }
      if (struct.isSetDeleteType()) {
        optionals.set(2);
      }
      if (struct.isSetAttributes()) {
        optionals.set(3);
      }
      if (struct.isSetDurability()) {
        optionals.set(4);
      }
      oprot.writeBitSet(optionals, 5);
      if (struct.isSetColumns()) {
        {
          oprot.writeI32(struct.columns.size());
          for (TColumn _iter61 : struct.columns)
          {
            _iter61.write(oprot);
          }
        }
      }
      if (struct.isSetTimestamp()) {
        oprot.writeI64(struct.timestamp);
      }
      if (struct.isSetDeleteType()) {
        oprot.writeI32(struct.deleteType.getValue());
      }
      if (struct.isSetAttributes()) {
        {
          oprot.writeI32(struct.attributes.size());
          for (java.util.Map.Entry<java.nio.ByteBuffer, java.nio.ByteBuffer> _iter62 : struct.attributes.entrySet())
          {
            oprot.writeBinary(_iter62.getKey());
            oprot.writeBinary(_iter62.getValue());
          }
        }
      }
      if (struct.isSetDurability()) {
        oprot.writeI32(struct.durability.getValue());
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TDelete struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.row = iprot.readBinary();
      struct.setRowIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(5);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list63 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.columns = new java.util.ArrayList<TColumn>(_list63.size);
          @org.apache.thrift.annotation.Nullable TColumn _elem64;
          for (int _i65 = 0; _i65 < _list63.size; ++_i65)
          {
            _elem64 = new TColumn();
            _elem64.read(iprot);
            struct.columns.add(_elem64);
          }
        }
        struct.setColumnsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.timestamp = iprot.readI64();
        struct.setTimestampIsSet(true);
      }
      if (incoming.get(2)) {
        struct.deleteType = org.apache.hadoop.hbase.thrift2.generated.TDeleteType.findByValue(iprot.readI32());
        struct.setDeleteTypeIsSet(true);
      }
      if (incoming.get(3)) {
        {
          org.apache.thrift.protocol.TMap _map66 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.STRING, iprot.readI32());
          struct.attributes = new java.util.HashMap<java.nio.ByteBuffer,java.nio.ByteBuffer>(2*_map66.size);
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _key67;
          @org.apache.thrift.annotation.Nullable java.nio.ByteBuffer _val68;
          for (int _i69 = 0; _i69 < _map66.size; ++_i69)
          {
            _key67 = iprot.readBinary();
            _val68 = iprot.readBinary();
            struct.attributes.put(_key67, _val68);
          }
        }
        struct.setAttributesIsSet(true);
      }
      if (incoming.get(4)) {
        struct.durability = org.apache.hadoop.hbase.thrift2.generated.TDurability.findByValue(iprot.readI32());
        struct.setDurabilityIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

