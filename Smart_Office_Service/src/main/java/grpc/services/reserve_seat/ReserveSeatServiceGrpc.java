package grpc.services.reserve_seat;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.*;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.*;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Reserve_Seat.proto")
public final class ReserveSeatServiceGrpc {

  private ReserveSeatServiceGrpc() {}

  public static final String SERVICE_NAME = "office_service.ReserveSeatService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.reserve_seat.AvailableSeatRequest,
      grpc.services.reserve_seat.AvailableSeatResponse> getAvailableSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "availableSeat",
      requestType = grpc.services.reserve_seat.AvailableSeatRequest.class,
      responseType = grpc.services.reserve_seat.AvailableSeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.reserve_seat.AvailableSeatRequest,
      grpc.services.reserve_seat.AvailableSeatResponse> getAvailableSeatMethod() {
    io.grpc.MethodDescriptor<grpc.services.reserve_seat.AvailableSeatRequest, grpc.services.reserve_seat.AvailableSeatResponse> getAvailableSeatMethod;
    if ((getAvailableSeatMethod = ReserveSeatServiceGrpc.getAvailableSeatMethod) == null) {
      synchronized (ReserveSeatServiceGrpc.class) {
        if ((getAvailableSeatMethod = ReserveSeatServiceGrpc.getAvailableSeatMethod) == null) {
          ReserveSeatServiceGrpc.getAvailableSeatMethod = getAvailableSeatMethod = 
              io.grpc.MethodDescriptor.<grpc.services.reserve_seat.AvailableSeatRequest, grpc.services.reserve_seat.AvailableSeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "office_service.ReserveSeatService", "availableSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.reserve_seat.AvailableSeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.reserve_seat.AvailableSeatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReserveSeatServiceMethodDescriptorSupplier("availableSeat"))
                  .build();
          }
        }
     }
     return getAvailableSeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.reserve_seat.ReserveSeatRequest,
      grpc.services.reserve_seat.ReserveSeatResponse> getReserveSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "reserveSeat",
      requestType = grpc.services.reserve_seat.ReserveSeatRequest.class,
      responseType = grpc.services.reserve_seat.ReserveSeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.reserve_seat.ReserveSeatRequest,
      grpc.services.reserve_seat.ReserveSeatResponse> getReserveSeatMethod() {
    io.grpc.MethodDescriptor<grpc.services.reserve_seat.ReserveSeatRequest, grpc.services.reserve_seat.ReserveSeatResponse> getReserveSeatMethod;
    if ((getReserveSeatMethod = ReserveSeatServiceGrpc.getReserveSeatMethod) == null) {
      synchronized (ReserveSeatServiceGrpc.class) {
        if ((getReserveSeatMethod = ReserveSeatServiceGrpc.getReserveSeatMethod) == null) {
          ReserveSeatServiceGrpc.getReserveSeatMethod = getReserveSeatMethod = 
              io.grpc.MethodDescriptor.<grpc.services.reserve_seat.ReserveSeatRequest, grpc.services.reserve_seat.ReserveSeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "office_service.ReserveSeatService", "reserveSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.reserve_seat.ReserveSeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.reserve_seat.ReserveSeatResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new ReserveSeatServiceMethodDescriptorSupplier("reserveSeat"))
                  .build();
          }
        }
     }
     return getReserveSeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReserveSeatServiceStub newStub(io.grpc.Channel channel) {
    return new ReserveSeatServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReserveSeatServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReserveSeatServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReserveSeatServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReserveSeatServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class ReserveSeatServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for server stream calls
     * </pre>
     */
    public void availableSeat(grpc.services.reserve_seat.AvailableSeatRequest request,
        io.grpc.stub.StreamObserver<grpc.services.reserve_seat.AvailableSeatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getAvailableSeatMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public void reserveSeat(grpc.services.reserve_seat.ReserveSeatRequest request,
        io.grpc.stub.StreamObserver<grpc.services.reserve_seat.ReserveSeatResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getReserveSeatMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAvailableSeatMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.services.reserve_seat.AvailableSeatRequest,
                grpc.services.reserve_seat.AvailableSeatResponse>(
                  this, METHODID_AVAILABLE_SEAT)))
          .addMethod(
            getReserveSeatMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.reserve_seat.ReserveSeatRequest,
                grpc.services.reserve_seat.ReserveSeatResponse>(
                  this, METHODID_RESERVE_SEAT)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ReserveSeatServiceStub extends io.grpc.stub.AbstractStub<ReserveSeatServiceStub> {
    private ReserveSeatServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReserveSeatServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReserveSeatServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReserveSeatServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for server stream calls
     * </pre>
     */
    public void availableSeat(grpc.services.reserve_seat.AvailableSeatRequest request,
        io.grpc.stub.StreamObserver<grpc.services.reserve_seat.AvailableSeatResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getAvailableSeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public void reserveSeat(grpc.services.reserve_seat.ReserveSeatRequest request,
        io.grpc.stub.StreamObserver<grpc.services.reserve_seat.ReserveSeatResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ReserveSeatServiceBlockingStub extends io.grpc.stub.AbstractStub<ReserveSeatServiceBlockingStub> {
    private ReserveSeatServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReserveSeatServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReserveSeatServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReserveSeatServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for server stream calls
     * </pre>
     */
    public java.util.Iterator<grpc.services.reserve_seat.AvailableSeatResponse> availableSeat(
        grpc.services.reserve_seat.AvailableSeatRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getAvailableSeatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public grpc.services.reserve_seat.ReserveSeatResponse reserveSeat(grpc.services.reserve_seat.ReserveSeatRequest request) {
      return blockingUnaryCall(
          getChannel(), getReserveSeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class ReserveSeatServiceFutureStub extends io.grpc.stub.AbstractStub<ReserveSeatServiceFutureStub> {
    private ReserveSeatServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReserveSeatServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReserveSeatServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReserveSeatServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for unary calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.reserve_seat.ReserveSeatResponse> reserveSeat(
        grpc.services.reserve_seat.ReserveSeatRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AVAILABLE_SEAT = 0;
  private static final int METHODID_RESERVE_SEAT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReserveSeatServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReserveSeatServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AVAILABLE_SEAT:
          serviceImpl.availableSeat((grpc.services.reserve_seat.AvailableSeatRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.reserve_seat.AvailableSeatResponse>) responseObserver);
          break;
        case METHODID_RESERVE_SEAT:
          serviceImpl.reserveSeat((grpc.services.reserve_seat.ReserveSeatRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.reserve_seat.ReserveSeatResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ReserveSeatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReserveSeatServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.reserve_seat.ReserveSeatServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReserveSeatService");
    }
  }

  private static final class ReserveSeatServiceFileDescriptorSupplier
      extends ReserveSeatServiceBaseDescriptorSupplier {
    ReserveSeatServiceFileDescriptorSupplier() {}
  }

  private static final class ReserveSeatServiceMethodDescriptorSupplier
      extends ReserveSeatServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ReserveSeatServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReserveSeatServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReserveSeatServiceFileDescriptorSupplier())
              .addMethod(getAvailableSeatMethod())
              .addMethod(getReserveSeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
