package grpc.services.payroll_year_end;

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
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: Payroll_Year_End.proto")
public final class PayrollYearEndServiceGrpc {

  private PayrollYearEndServiceGrpc() {}

  public static final String SERVICE_NAME = "office_service.PayrollYearEndService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.payroll_year_end.PayrollYearEndRequest,
      grpc.services.payroll_year_end.PayrollYearEndResponse> getInputHourMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "input_hour",
      requestType = grpc.services.payroll_year_end.PayrollYearEndRequest.class,
      responseType = grpc.services.payroll_year_end.PayrollYearEndResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.payroll_year_end.PayrollYearEndRequest,
      grpc.services.payroll_year_end.PayrollYearEndResponse> getInputHourMethod() {
    io.grpc.MethodDescriptor<grpc.services.payroll_year_end.PayrollYearEndRequest, grpc.services.payroll_year_end.PayrollYearEndResponse> getInputHourMethod;
    if ((getInputHourMethod = PayrollYearEndServiceGrpc.getInputHourMethod) == null) {
      synchronized (PayrollYearEndServiceGrpc.class) {
        if ((getInputHourMethod = PayrollYearEndServiceGrpc.getInputHourMethod) == null) {
          PayrollYearEndServiceGrpc.getInputHourMethod = getInputHourMethod = 
              io.grpc.MethodDescriptor.<grpc.services.payroll_year_end.PayrollYearEndRequest, grpc.services.payroll_year_end.PayrollYearEndResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "office_service.PayrollYearEndService", "input_hour"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.payroll_year_end.PayrollYearEndRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.payroll_year_end.PayrollYearEndResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new PayrollYearEndServiceMethodDescriptorSupplier("input_hour"))
                  .build();
          }
        }
     }
     return getInputHourMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PayrollYearEndServiceStub newStub(io.grpc.Channel channel) {
    return new PayrollYearEndServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PayrollYearEndServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PayrollYearEndServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PayrollYearEndServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PayrollYearEndServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class PayrollYearEndServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.payroll_year_end.PayrollYearEndRequest> inputHour(
        io.grpc.stub.StreamObserver<grpc.services.payroll_year_end.PayrollYearEndResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getInputHourMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getInputHourMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.services.payroll_year_end.PayrollYearEndRequest,
                grpc.services.payroll_year_end.PayrollYearEndResponse>(
                  this, METHODID_INPUT_HOUR)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PayrollYearEndServiceStub extends io.grpc.stub.AbstractStub<PayrollYearEndServiceStub> {
    private PayrollYearEndServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayrollYearEndServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayrollYearEndServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayrollYearEndServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.payroll_year_end.PayrollYearEndRequest> inputHour(
        io.grpc.stub.StreamObserver<grpc.services.payroll_year_end.PayrollYearEndResponse> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getInputHourMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PayrollYearEndServiceBlockingStub extends io.grpc.stub.AbstractStub<PayrollYearEndServiceBlockingStub> {
    private PayrollYearEndServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayrollYearEndServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayrollYearEndServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayrollYearEndServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class PayrollYearEndServiceFutureStub extends io.grpc.stub.AbstractStub<PayrollYearEndServiceFutureStub> {
    private PayrollYearEndServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PayrollYearEndServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PayrollYearEndServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PayrollYearEndServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_INPUT_HOUR = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PayrollYearEndServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PayrollYearEndServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_INPUT_HOUR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.inputHour(
              (io.grpc.stub.StreamObserver<grpc.services.payroll_year_end.PayrollYearEndResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PayrollYearEndServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PayrollYearEndServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.payroll_year_end.PayrollYearEndServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PayrollYearEndService");
    }
  }

  private static final class PayrollYearEndServiceFileDescriptorSupplier
      extends PayrollYearEndServiceBaseDescriptorSupplier {
    PayrollYearEndServiceFileDescriptorSupplier() {}
  }

  private static final class PayrollYearEndServiceMethodDescriptorSupplier
      extends PayrollYearEndServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PayrollYearEndServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (PayrollYearEndServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PayrollYearEndServiceFileDescriptorSupplier())
              .addMethod(getInputHourMethod())
              .build();
        }
      }
    }
    return result;
  }
}
