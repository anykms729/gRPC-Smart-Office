package grpc.services.hr_department_service;

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
    comments = "Source: HRDepartmentService.proto")
public final class HRDepartmentServiceGrpc {

  private HRDepartmentServiceGrpc() {}

  public static final String SERVICE_NAME = "office_service.HRDepartmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.hr_department_service.WeeklyWorkingHourRequest,
      grpc.services.hr_department_service.WeeklyWorkingHourResponse> getCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "check",
      requestType = grpc.services.hr_department_service.WeeklyWorkingHourRequest.class,
      responseType = grpc.services.hr_department_service.WeeklyWorkingHourResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.hr_department_service.WeeklyWorkingHourRequest,
      grpc.services.hr_department_service.WeeklyWorkingHourResponse> getCheckMethod() {
    io.grpc.MethodDescriptor<grpc.services.hr_department_service.WeeklyWorkingHourRequest, grpc.services.hr_department_service.WeeklyWorkingHourResponse> getCheckMethod;
    if ((getCheckMethod = HRDepartmentServiceGrpc.getCheckMethod) == null) {
      synchronized (HRDepartmentServiceGrpc.class) {
        if ((getCheckMethod = HRDepartmentServiceGrpc.getCheckMethod) == null) {
          HRDepartmentServiceGrpc.getCheckMethod = getCheckMethod = 
              io.grpc.MethodDescriptor.<grpc.services.hr_department_service.WeeklyWorkingHourRequest, grpc.services.hr_department_service.WeeklyWorkingHourResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "office_service.HRDepartmentService", "check"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.hr_department_service.WeeklyWorkingHourRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.hr_department_service.WeeklyWorkingHourResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HRDepartmentServiceMethodDescriptorSupplier("check"))
                  .build();
          }
        }
     }
     return getCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.hr_department_service.Monthly_Payroll_Request,
      grpc.services.hr_department_service.Monthly_Payroll_Response> getInputHourMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "input_hour",
      requestType = grpc.services.hr_department_service.Monthly_Payroll_Request.class,
      responseType = grpc.services.hr_department_service.Monthly_Payroll_Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.hr_department_service.Monthly_Payroll_Request,
      grpc.services.hr_department_service.Monthly_Payroll_Response> getInputHourMethod() {
    io.grpc.MethodDescriptor<grpc.services.hr_department_service.Monthly_Payroll_Request, grpc.services.hr_department_service.Monthly_Payroll_Response> getInputHourMethod;
    if ((getInputHourMethod = HRDepartmentServiceGrpc.getInputHourMethod) == null) {
      synchronized (HRDepartmentServiceGrpc.class) {
        if ((getInputHourMethod = HRDepartmentServiceGrpc.getInputHourMethod) == null) {
          HRDepartmentServiceGrpc.getInputHourMethod = getInputHourMethod = 
              io.grpc.MethodDescriptor.<grpc.services.hr_department_service.Monthly_Payroll_Request, grpc.services.hr_department_service.Monthly_Payroll_Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "office_service.HRDepartmentService", "input_hour"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.hr_department_service.Monthly_Payroll_Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.hr_department_service.Monthly_Payroll_Response.getDefaultInstance()))
                  .setSchemaDescriptor(new HRDepartmentServiceMethodDescriptorSupplier("input_hour"))
                  .build();
          }
        }
     }
     return getInputHourMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HRDepartmentServiceStub newStub(io.grpc.Channel channel) {
    return new HRDepartmentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HRDepartmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HRDepartmentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HRDepartmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HRDepartmentServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class HRDepartmentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for Bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.hr_department_service.WeeklyWorkingHourRequest> check(
        io.grpc.stub.StreamObserver<grpc.services.hr_department_service.WeeklyWorkingHourResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.hr_department_service.Monthly_Payroll_Request> inputHour(
        io.grpc.stub.StreamObserver<grpc.services.hr_department_service.Monthly_Payroll_Response> responseObserver) {
      return asyncUnimplementedStreamingCall(getInputHourMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.hr_department_service.WeeklyWorkingHourRequest,
                grpc.services.hr_department_service.WeeklyWorkingHourResponse>(
                  this, METHODID_CHECK)))
          .addMethod(
            getInputHourMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                grpc.services.hr_department_service.Monthly_Payroll_Request,
                grpc.services.hr_department_service.Monthly_Payroll_Response>(
                  this, METHODID_INPUT_HOUR)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HRDepartmentServiceStub extends io.grpc.stub.AbstractStub<HRDepartmentServiceStub> {
    private HRDepartmentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HRDepartmentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HRDepartmentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HRDepartmentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for Bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.hr_department_service.WeeklyWorkingHourRequest> check(
        io.grpc.stub.StreamObserver<grpc.services.hr_department_service.WeeklyWorkingHourResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getCheckMethod(), getCallOptions()), responseObserver);
    }

    /**
     * <pre>
     * rpc method for client streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.hr_department_service.Monthly_Payroll_Request> inputHour(
        io.grpc.stub.StreamObserver<grpc.services.hr_department_service.Monthly_Payroll_Response> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getInputHourMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HRDepartmentServiceBlockingStub extends io.grpc.stub.AbstractStub<HRDepartmentServiceBlockingStub> {
    private HRDepartmentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HRDepartmentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HRDepartmentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HRDepartmentServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class HRDepartmentServiceFutureStub extends io.grpc.stub.AbstractStub<HRDepartmentServiceFutureStub> {
    private HRDepartmentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HRDepartmentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HRDepartmentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HRDepartmentServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_CHECK = 0;
  private static final int METHODID_INPUT_HOUR = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HRDepartmentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HRDepartmentServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_CHECK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.check(
              (io.grpc.stub.StreamObserver<grpc.services.hr_department_service.WeeklyWorkingHourResponse>) responseObserver);
        case METHODID_INPUT_HOUR:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.inputHour(
              (io.grpc.stub.StreamObserver<grpc.services.hr_department_service.Monthly_Payroll_Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class HRDepartmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HRDepartmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.hr_department_service.HRDepartmentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("HRDepartmentService");
    }
  }

  private static final class HRDepartmentServiceFileDescriptorSupplier
      extends HRDepartmentServiceBaseDescriptorSupplier {
    HRDepartmentServiceFileDescriptorSupplier() {}
  }

  private static final class HRDepartmentServiceMethodDescriptorSupplier
      extends HRDepartmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HRDepartmentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (HRDepartmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HRDepartmentServiceFileDescriptorSupplier())
              .addMethod(getCheckMethod())
              .addMethod(getInputHourMethod())
              .build();
        }
      }
    }
    return result;
  }
}
