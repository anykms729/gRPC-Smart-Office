// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Reserve_Seat.proto

package grpc.services.reserve_seat;

public final class ReserveSeatServiceImpl {
  private ReserveSeatServiceImpl() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_strings_ReserveSeatRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_strings_ReserveSeatRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_strings_ReserveSeatRequestResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_strings_ReserveSeatRequestResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_strings_Message_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_strings_Message_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_strings_Empty_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_strings_Empty_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\022Reserve_Seat.proto\022\007strings\"!\n\022Reserve" +
      "SeatRequest\022\013\n\003val\030\001 \001(\t\")\n\032ReserveSeatR" +
      "equestResponse\022\013\n\003val\030\001 \001(\t\"X\n\007Message\022%" +
      "\n\006detail\030\001 \001(\0162\025.strings.Message.Enum\"&\n" +
      "\004Enum\022\013\n\007UNKNOWN\020\000\022\007\n\003LOW\020\001\022\010\n\004HIGH\020\002\"\007\n" +
      "\005Empty2\220\001\n\022ReserveSeatService\022M\n\007reserve" +
      "\022\033.strings.ReserveSeatRequest\032#.strings." +
      "ReserveSeatRequestResponse\"\000\022+\n\005empty\022\020." +
      "strings.Message\032\016.strings.Empty\"\000B6\n\032grp" +
      "c.services.reserve_seatB\026ReserveSeatServ" +
      "iceImplP\001b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_strings_ReserveSeatRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_strings_ReserveSeatRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_strings_ReserveSeatRequest_descriptor,
        new java.lang.String[] { "Val", });
    internal_static_strings_ReserveSeatRequestResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_strings_ReserveSeatRequestResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_strings_ReserveSeatRequestResponse_descriptor,
        new java.lang.String[] { "Val", });
    internal_static_strings_Message_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_strings_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_strings_Message_descriptor,
        new java.lang.String[] { "Detail", });
    internal_static_strings_Empty_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_strings_Empty_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_strings_Empty_descriptor,
        new java.lang.String[] { });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
