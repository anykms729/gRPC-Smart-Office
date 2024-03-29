// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Sales_Department_Service.proto

package grpc.services.sales_department_service;

/**
 * Protobuf type {@code office_service.StockRequest}
 */
public  final class StockRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:office_service.StockRequest)
    StockRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use StockRequest.newBuilder() to construct.
  private StockRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private StockRequest() {
    stockRequestProductQuantity_ = 0;
    stockRequestProductType_ = "";
    stockRequestMessage_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private StockRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 8: {

            stockRequestProductQuantity_ = input.readInt32();
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            stockRequestProductType_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            stockRequestMessage_ = s;
            break;
          }
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return grpc.services.sales_department_service.SalesDepartmentServiceImpl.internal_static_office_service_StockRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.services.sales_department_service.SalesDepartmentServiceImpl.internal_static_office_service_StockRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.services.sales_department_service.StockRequest.class, grpc.services.sales_department_service.StockRequest.Builder.class);
  }

  public static final int STOCK_REQUEST_PRODUCT_QUANTITY_FIELD_NUMBER = 1;
  private int stockRequestProductQuantity_;
  /**
   * <code>int32 stock_request_product_quantity = 1;</code>
   */
  public int getStockRequestProductQuantity() {
    return stockRequestProductQuantity_;
  }

  public static final int STOCK_REQUEST_PRODUCT_TYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object stockRequestProductType_;
  /**
   * <code>string stock_request_product_type = 2;</code>
   */
  public java.lang.String getStockRequestProductType() {
    java.lang.Object ref = stockRequestProductType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      stockRequestProductType_ = s;
      return s;
    }
  }
  /**
   * <code>string stock_request_product_type = 2;</code>
   */
  public com.google.protobuf.ByteString
      getStockRequestProductTypeBytes() {
    java.lang.Object ref = stockRequestProductType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      stockRequestProductType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int STOCK_REQUEST_MESSAGE_FIELD_NUMBER = 3;
  private volatile java.lang.Object stockRequestMessage_;
  /**
   * <code>string stock_request_message = 3;</code>
   */
  public java.lang.String getStockRequestMessage() {
    java.lang.Object ref = stockRequestMessage_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      stockRequestMessage_ = s;
      return s;
    }
  }
  /**
   * <code>string stock_request_message = 3;</code>
   */
  public com.google.protobuf.ByteString
      getStockRequestMessageBytes() {
    java.lang.Object ref = stockRequestMessage_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      stockRequestMessage_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (stockRequestProductQuantity_ != 0) {
      output.writeInt32(1, stockRequestProductQuantity_);
    }
    if (!getStockRequestProductTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, stockRequestProductType_);
    }
    if (!getStockRequestMessageBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, stockRequestMessage_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (stockRequestProductQuantity_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, stockRequestProductQuantity_);
    }
    if (!getStockRequestProductTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, stockRequestProductType_);
    }
    if (!getStockRequestMessageBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, stockRequestMessage_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof grpc.services.sales_department_service.StockRequest)) {
      return super.equals(obj);
    }
    grpc.services.sales_department_service.StockRequest other = (grpc.services.sales_department_service.StockRequest) obj;

    boolean result = true;
    result = result && (getStockRequestProductQuantity()
        == other.getStockRequestProductQuantity());
    result = result && getStockRequestProductType()
        .equals(other.getStockRequestProductType());
    result = result && getStockRequestMessage()
        .equals(other.getStockRequestMessage());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + STOCK_REQUEST_PRODUCT_QUANTITY_FIELD_NUMBER;
    hash = (53 * hash) + getStockRequestProductQuantity();
    hash = (37 * hash) + STOCK_REQUEST_PRODUCT_TYPE_FIELD_NUMBER;
    hash = (53 * hash) + getStockRequestProductType().hashCode();
    hash = (37 * hash) + STOCK_REQUEST_MESSAGE_FIELD_NUMBER;
    hash = (53 * hash) + getStockRequestMessage().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.services.sales_department_service.StockRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.sales_department_service.StockRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.services.sales_department_service.StockRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.sales_department_service.StockRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(grpc.services.sales_department_service.StockRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code office_service.StockRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:office_service.StockRequest)
      grpc.services.sales_department_service.StockRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.services.sales_department_service.SalesDepartmentServiceImpl.internal_static_office_service_StockRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.services.sales_department_service.SalesDepartmentServiceImpl.internal_static_office_service_StockRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.services.sales_department_service.StockRequest.class, grpc.services.sales_department_service.StockRequest.Builder.class);
    }

    // Construct using grpc.services.sales_department_service.StockRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      stockRequestProductQuantity_ = 0;

      stockRequestProductType_ = "";

      stockRequestMessage_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.services.sales_department_service.SalesDepartmentServiceImpl.internal_static_office_service_StockRequest_descriptor;
    }

    @java.lang.Override
    public grpc.services.sales_department_service.StockRequest getDefaultInstanceForType() {
      return grpc.services.sales_department_service.StockRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.services.sales_department_service.StockRequest build() {
      grpc.services.sales_department_service.StockRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.services.sales_department_service.StockRequest buildPartial() {
      grpc.services.sales_department_service.StockRequest result = new grpc.services.sales_department_service.StockRequest(this);
      result.stockRequestProductQuantity_ = stockRequestProductQuantity_;
      result.stockRequestProductType_ = stockRequestProductType_;
      result.stockRequestMessage_ = stockRequestMessage_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return (Builder) super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof grpc.services.sales_department_service.StockRequest) {
        return mergeFrom((grpc.services.sales_department_service.StockRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.services.sales_department_service.StockRequest other) {
      if (other == grpc.services.sales_department_service.StockRequest.getDefaultInstance()) return this;
      if (other.getStockRequestProductQuantity() != 0) {
        setStockRequestProductQuantity(other.getStockRequestProductQuantity());
      }
      if (!other.getStockRequestProductType().isEmpty()) {
        stockRequestProductType_ = other.stockRequestProductType_;
        onChanged();
      }
      if (!other.getStockRequestMessage().isEmpty()) {
        stockRequestMessage_ = other.stockRequestMessage_;
        onChanged();
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      grpc.services.sales_department_service.StockRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.services.sales_department_service.StockRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private int stockRequestProductQuantity_ ;
    /**
     * <code>int32 stock_request_product_quantity = 1;</code>
     */
    public int getStockRequestProductQuantity() {
      return stockRequestProductQuantity_;
    }
    /**
     * <code>int32 stock_request_product_quantity = 1;</code>
     */
    public Builder setStockRequestProductQuantity(int value) {
      
      stockRequestProductQuantity_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>int32 stock_request_product_quantity = 1;</code>
     */
    public Builder clearStockRequestProductQuantity() {
      
      stockRequestProductQuantity_ = 0;
      onChanged();
      return this;
    }

    private java.lang.Object stockRequestProductType_ = "";
    /**
     * <code>string stock_request_product_type = 2;</code>
     */
    public java.lang.String getStockRequestProductType() {
      java.lang.Object ref = stockRequestProductType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        stockRequestProductType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string stock_request_product_type = 2;</code>
     */
    public com.google.protobuf.ByteString
        getStockRequestProductTypeBytes() {
      java.lang.Object ref = stockRequestProductType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        stockRequestProductType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string stock_request_product_type = 2;</code>
     */
    public Builder setStockRequestProductType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      stockRequestProductType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string stock_request_product_type = 2;</code>
     */
    public Builder clearStockRequestProductType() {
      
      stockRequestProductType_ = getDefaultInstance().getStockRequestProductType();
      onChanged();
      return this;
    }
    /**
     * <code>string stock_request_product_type = 2;</code>
     */
    public Builder setStockRequestProductTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      stockRequestProductType_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object stockRequestMessage_ = "";
    /**
     * <code>string stock_request_message = 3;</code>
     */
    public java.lang.String getStockRequestMessage() {
      java.lang.Object ref = stockRequestMessage_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        stockRequestMessage_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string stock_request_message = 3;</code>
     */
    public com.google.protobuf.ByteString
        getStockRequestMessageBytes() {
      java.lang.Object ref = stockRequestMessage_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        stockRequestMessage_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string stock_request_message = 3;</code>
     */
    public Builder setStockRequestMessage(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      stockRequestMessage_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string stock_request_message = 3;</code>
     */
    public Builder clearStockRequestMessage() {
      
      stockRequestMessage_ = getDefaultInstance().getStockRequestMessage();
      onChanged();
      return this;
    }
    /**
     * <code>string stock_request_message = 3;</code>
     */
    public Builder setStockRequestMessageBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      stockRequestMessage_ = value;
      onChanged();
      return this;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:office_service.StockRequest)
  }

  // @@protoc_insertion_point(class_scope:office_service.StockRequest)
  private static final grpc.services.sales_department_service.StockRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.services.sales_department_service.StockRequest();
  }

  public static grpc.services.sales_department_service.StockRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<StockRequest>
      PARSER = new com.google.protobuf.AbstractParser<StockRequest>() {
    @java.lang.Override
    public StockRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new StockRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<StockRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<StockRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.services.sales_department_service.StockRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

