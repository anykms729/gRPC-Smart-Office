package grpc.services.order_automation;

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
    comments = "Source: Order_Automation.proto")
public final class OrderAutomationServiceGrpc {

  private OrderAutomationServiceGrpc() {}

  public static final String SERVICE_NAME = "strings.OrderAutomationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.order_automation.OrderAutomationRequest,
      grpc.services.order_automation.OrderAutomationResponse> getOrderMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "order",
      requestType = grpc.services.order_automation.OrderAutomationRequest.class,
      responseType = grpc.services.order_automation.OrderAutomationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.order_automation.OrderAutomationRequest,
      grpc.services.order_automation.OrderAutomationResponse> getOrderMethod() {
    io.grpc.MethodDescriptor<grpc.services.order_automation.OrderAutomationRequest, grpc.services.order_automation.OrderAutomationResponse> getOrderMethod;
    if ((getOrderMethod = OrderAutomationServiceGrpc.getOrderMethod) == null) {
      synchronized (OrderAutomationServiceGrpc.class) {
        if ((getOrderMethod = OrderAutomationServiceGrpc.getOrderMethod) == null) {
          OrderAutomationServiceGrpc.getOrderMethod = getOrderMethod = 
              io.grpc.MethodDescriptor.<grpc.services.order_automation.OrderAutomationRequest, grpc.services.order_automation.OrderAutomationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "strings.OrderAutomationService", "order"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.order_automation.OrderAutomationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.order_automation.OrderAutomationResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new OrderAutomationServiceMethodDescriptorSupplier("order"))
                  .build();
          }
        }
     }
     return getOrderMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static OrderAutomationServiceStub newStub(io.grpc.Channel channel) {
    return new OrderAutomationServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static OrderAutomationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new OrderAutomationServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static OrderAutomationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new OrderAutomationServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class OrderAutomationServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.order_automation.OrderAutomationRequest> order(
        io.grpc.stub.StreamObserver<grpc.services.order_automation.OrderAutomationResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getOrderMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getOrderMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.order_automation.OrderAutomationRequest,
                grpc.services.order_automation.OrderAutomationResponse>(
                  this, METHODID_ORDER)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class OrderAutomationServiceStub extends io.grpc.stub.AbstractStub<OrderAutomationServiceStub> {
    private OrderAutomationServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderAutomationServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderAutomationServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderAutomationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public io.grpc.stub.StreamObserver<grpc.services.order_automation.OrderAutomationRequest> order(
        io.grpc.stub.StreamObserver<grpc.services.order_automation.OrderAutomationResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getOrderMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class OrderAutomationServiceBlockingStub extends io.grpc.stub.AbstractStub<OrderAutomationServiceBlockingStub> {
    private OrderAutomationServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderAutomationServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderAutomationServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderAutomationServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class OrderAutomationServiceFutureStub extends io.grpc.stub.AbstractStub<OrderAutomationServiceFutureStub> {
    private OrderAutomationServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private OrderAutomationServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected OrderAutomationServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new OrderAutomationServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ORDER = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final OrderAutomationServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(OrderAutomationServiceImplBase serviceImpl, int methodId) {
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
        case METHODID_ORDER:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.order(
              (io.grpc.stub.StreamObserver<grpc.services.order_automation.OrderAutomationResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class OrderAutomationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    OrderAutomationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.order_automation.OrderAutomationServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("OrderAutomationService");
    }
  }

  private static final class OrderAutomationServiceFileDescriptorSupplier
      extends OrderAutomationServiceBaseDescriptorSupplier {
    OrderAutomationServiceFileDescriptorSupplier() {}
  }

  private static final class OrderAutomationServiceMethodDescriptorSupplier
      extends OrderAutomationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    OrderAutomationServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (OrderAutomationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new OrderAutomationServiceFileDescriptorSupplier())
              .addMethod(getOrderMethod())
              .build();
        }
      }
    }
    return result;
  }
}
