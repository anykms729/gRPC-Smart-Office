// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Reserve_Seat.proto

package grpc.services.reserve_seat;

/**
 * <pre>
 * define each variable in rpc method separately
 * </pre>
 *
 * Protobuf type {@code strings.ReserveSeatRequest}
 */
public  final class ReserveSeatRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:strings.ReserveSeatRequest)
    ReserveSeatRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use ReserveSeatRequest.newBuilder() to construct.
  private ReserveSeatRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private ReserveSeatRequest() {
    val_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private ReserveSeatRequest(
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
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            val_ = s;
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
    return grpc.services.reserve_seat.ReserveSeatServiceImpl.internal_static_strings_ReserveSeatRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return grpc.services.reserve_seat.ReserveSeatServiceImpl.internal_static_strings_ReserveSeatRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            grpc.services.reserve_seat.ReserveSeatRequest.class, grpc.services.reserve_seat.ReserveSeatRequest.Builder.class);
  }

  public static final int VAL_FIELD_NUMBER = 1;
  private volatile java.lang.Object val_;
  /**
   * <code>string val = 1;</code>
   */
  public java.lang.String getVal() {
    java.lang.Object ref = val_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      val_ = s;
      return s;
    }
  }
  /**
   * <code>string val = 1;</code>
   */
  public com.google.protobuf.ByteString
      getValBytes() {
    java.lang.Object ref = val_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      val_ = b;
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
    if (!getValBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, val_);
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getValBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, val_);
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
    if (!(obj instanceof grpc.services.reserve_seat.ReserveSeatRequest)) {
      return super.equals(obj);
    }
    grpc.services.reserve_seat.ReserveSeatRequest other = (grpc.services.reserve_seat.ReserveSeatRequest) obj;

    boolean result = true;
    result = result && getVal()
        .equals(other.getVal());
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
    hash = (37 * hash) + VAL_FIELD_NUMBER;
    hash = (53 * hash) + getVal().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static grpc.services.reserve_seat.ReserveSeatRequest parseFrom(
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
  public static Builder newBuilder(grpc.services.reserve_seat.ReserveSeatRequest prototype) {
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
   * <pre>
   * define each variable in rpc method separately
   * </pre>
   *
   * Protobuf type {@code strings.ReserveSeatRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:strings.ReserveSeatRequest)
      grpc.services.reserve_seat.ReserveSeatRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return grpc.services.reserve_seat.ReserveSeatServiceImpl.internal_static_strings_ReserveSeatRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return grpc.services.reserve_seat.ReserveSeatServiceImpl.internal_static_strings_ReserveSeatRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              grpc.services.reserve_seat.ReserveSeatRequest.class, grpc.services.reserve_seat.ReserveSeatRequest.Builder.class);
    }

    // Construct using grpc.services.reserve_seat.ReserveSeatRequest.newBuilder()
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
      val_ = "";

      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return grpc.services.reserve_seat.ReserveSeatServiceImpl.internal_static_strings_ReserveSeatRequest_descriptor;
    }

    @java.lang.Override
    public grpc.services.reserve_seat.ReserveSeatRequest getDefaultInstanceForType() {
      return grpc.services.reserve_seat.ReserveSeatRequest.getDefaultInstance();
    }

    @java.lang.Override
    public grpc.services.reserve_seat.ReserveSeatRequest build() {
      grpc.services.reserve_seat.ReserveSeatRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public grpc.services.reserve_seat.ReserveSeatRequest buildPartial() {
      grpc.services.reserve_seat.ReserveSeatRequest result = new grpc.services.reserve_seat.ReserveSeatRequest(this);
      result.val_ = val_;
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
      if (other instanceof grpc.services.reserve_seat.ReserveSeatRequest) {
        return mergeFrom((grpc.services.reserve_seat.ReserveSeatRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(grpc.services.reserve_seat.ReserveSeatRequest other) {
      if (other == grpc.services.reserve_seat.ReserveSeatRequest.getDefaultInstance()) return this;
      if (!other.getVal().isEmpty()) {
        val_ = other.val_;
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
      grpc.services.reserve_seat.ReserveSeatRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (grpc.services.reserve_seat.ReserveSeatRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object val_ = "";
    /**
     * <code>string val = 1;</code>
     */
    public java.lang.String getVal() {
      java.lang.Object ref = val_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        val_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string val = 1;</code>
     */
    public com.google.protobuf.ByteString
        getValBytes() {
      java.lang.Object ref = val_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        val_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string val = 1;</code>
     */
    public Builder setVal(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      val_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string val = 1;</code>
     */
    public Builder clearVal() {
      
      val_ = getDefaultInstance().getVal();
      onChanged();
      return this;
    }
    /**
     * <code>string val = 1;</code>
     */
    public Builder setValBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      val_ = value;
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


    // @@protoc_insertion_point(builder_scope:strings.ReserveSeatRequest)
  }

  // @@protoc_insertion_point(class_scope:strings.ReserveSeatRequest)
  private static final grpc.services.reserve_seat.ReserveSeatRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new grpc.services.reserve_seat.ReserveSeatRequest();
  }

  public static grpc.services.reserve_seat.ReserveSeatRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ReserveSeatRequest>
      PARSER = new com.google.protobuf.AbstractParser<ReserveSeatRequest>() {
    @java.lang.Override
    public ReserveSeatRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new ReserveSeatRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<ReserveSeatRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ReserveSeatRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public grpc.services.reserve_seat.ReserveSeatRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

