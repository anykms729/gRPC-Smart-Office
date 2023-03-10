package grpc.services.weekly_working_hour;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Weekly_Working_Hour.proto")
public final class WeeklyWorkingHourServiceGrpc {

  private WeeklyWorkingHourServiceGrpc() {}

  public static final String SERVICE_NAME = "strings.WeeklyWorkingHourService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.weekly_working_hour.WeeklyWorkingHourRequest,
      grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "check",
      requestType = grpc.services.weekly_working_hour.WeeklyWorkingHourRequest.class,
      responseType = grpc.services.weekly_working_hour.WeeklyWorkingHourResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.weekly_working_hour.WeeklyWorkingHourRequest,
      grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> getCheckMethod() {
    io.grpc.MethodDescriptor<grpc.services.weekly_working_hour.WeeklyWorkingHourRequest, grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> getCheckMethod;
    if ((getCheckMethod = WeeklyWorkingHourServiceGrpc.getCheckMethod) == null) {
      synchronized (WeeklyWorkingHourServiceGrpc.class) {
        if ((getCheckMethod = WeeklyWorkingHourServiceGrpc.getCheckMethod) == null) {
          WeeklyWorkingHourServiceGrpc.getCheckMethod = getCheckMethod = 
              io.grpc.MethodDescriptor.<grpc.services.weekly_working_hour.WeeklyWorkingHourRequest, grpc.services.weekly_working_hour.WeeklyWorkingHourResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "strings.WeeklyWorkingHourService", "check"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.weekly_working_hour.WeeklyWorkingHourRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.weekly_working_hour.WeeklyWorkingHourResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new WeeklyWorkingHourServiceMethodDescriptorSupplier("check"))
                  .build();
          }
        }
     }
     return getCheckMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WeeklyWorkingHourServiceStub newStub(io.grpc.Channel channel) {
    return new WeeklyWorkingHourServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WeeklyWorkingHourServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new WeeklyWorkingHourServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WeeklyWorkingHourServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new WeeklyWorkingHourServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class WeeklyWorkingHourServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public void check(grpc.services.weekly_working_hour.WeeklyWorkingHourRequest request,
        io.grpc.stub.StreamObserver<grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                grpc.services.weekly_working_hour.WeeklyWorkingHourRequest,
                grpc.services.weekly_working_hour.WeeklyWorkingHourResponse>(
                  this, METHODID_CHECK)))
          .build();
    }
  }

  /**
   */
  public static final class WeeklyWorkingHourServiceStub extends io.grpc.stub.AbstractStub<WeeklyWorkingHourServiceStub> {
    private WeeklyWorkingHourServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeeklyWorkingHourServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeeklyWorkingHourServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeeklyWorkingHourServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public void check(grpc.services.weekly_working_hour.WeeklyWorkingHourRequest request,
        io.grpc.stub.StreamObserver<grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class WeeklyWorkingHourServiceBlockingStub extends io.grpc.stub.AbstractStub<WeeklyWorkingHourServiceBlockingStub> {
    private WeeklyWorkingHourServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeeklyWorkingHourServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeeklyWorkingHourServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeeklyWorkingHourServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for server streaming calls
     * </pre>
     */
    public java.util.Iterator<grpc.services.weekly_working_hour.WeeklyWorkingHourResponse> check(
        grpc.services.weekly_working_hour.WeeklyWorkingHourRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getCheckMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class WeeklyWorkingHourServiceFutureStub extends io.grpc.stub.AbstractStub<WeeklyWorkingHourServiceFutureStub> {
    private WeeklyWorkingHourServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private WeeklyWorkingHourServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WeeklyWorkingHourServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new WeeklyWorkingHourServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final WeeklyWorkingHourServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(WeeklyWorkingHourServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK:
          serviceImpl.check((grpc.services.weekly_working_hour.WeeklyWorkingHourRequest) request,
              (io.grpc.stub.StreamObserver<grpc.services.weekly_working_hour.WeeklyWorkingHourResponse>) responseObserver);
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

  private static abstract class WeeklyWorkingHourServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WeeklyWorkingHourServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.weekly_working_hour.WeeklyWorkingHourServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WeeklyWorkingHourService");
    }
  }

  private static final class WeeklyWorkingHourServiceFileDescriptorSupplier
      extends WeeklyWorkingHourServiceBaseDescriptorSupplier {
    WeeklyWorkingHourServiceFileDescriptorSupplier() {}
  }

  private static final class WeeklyWorkingHourServiceMethodDescriptorSupplier
      extends WeeklyWorkingHourServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    WeeklyWorkingHourServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (WeeklyWorkingHourServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WeeklyWorkingHourServiceFileDescriptorSupplier())
              .addMethod(getCheckMethod())
              .build();
        }
      }
    }
    return result;
  }
}
