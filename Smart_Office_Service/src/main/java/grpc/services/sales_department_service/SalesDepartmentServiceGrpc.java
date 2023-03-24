package grpc.services.sales_department_service;

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
    comments = "Source: Sales_Department_Service.proto")
public final class SalesDepartmentServiceGrpc {

  private SalesDepartmentServiceGrpc() {}

  public static final String SERVICE_NAME = "office_service.SalesDepartmentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<grpc.services.sales_department_service.Stock_Request,
      grpc.services.sales_department_service.Stock_Response> getCheckStockMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "check_stock",
      requestType = grpc.services.sales_department_service.Stock_Request.class,
      responseType = grpc.services.sales_department_service.Stock_Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<grpc.services.sales_department_service.Stock_Request,
      grpc.services.sales_department_service.Stock_Response> getCheckStockMethod() {
    io.grpc.MethodDescriptor<grpc.services.sales_department_service.Stock_Request, grpc.services.sales_department_service.Stock_Response> getCheckStockMethod;
    if ((getCheckStockMethod = SalesDepartmentServiceGrpc.getCheckStockMethod) == null) {
      synchronized (SalesDepartmentServiceGrpc.class) {
        if ((getCheckStockMethod = SalesDepartmentServiceGrpc.getCheckStockMethod) == null) {
          SalesDepartmentServiceGrpc.getCheckStockMethod = getCheckStockMethod = 
              io.grpc.MethodDescriptor.<grpc.services.sales_department_service.Stock_Request, grpc.services.sales_department_service.Stock_Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "office_service.SalesDepartmentService", "check_stock"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.sales_department_service.Stock_Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.sales_department_service.Stock_Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SalesDepartmentServiceMethodDescriptorSupplier("check_stock"))
                  .build();
          }
        }
     }
     return getCheckStockMethod;
  }

  private static volatile io.grpc.MethodDescriptor<grpc.services.sales_department_service.Order_Request,
      grpc.services.sales_department_service.Order_Response> getOrderConfirmationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "order_confirmation",
      requestType = grpc.services.sales_department_service.Order_Request.class,
      responseType = grpc.services.sales_department_service.Order_Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<grpc.services.sales_department_service.Order_Request,
      grpc.services.sales_department_service.Order_Response> getOrderConfirmationMethod() {
    io.grpc.MethodDescriptor<grpc.services.sales_department_service.Order_Request, grpc.services.sales_department_service.Order_Response> getOrderConfirmationMethod;
    if ((getOrderConfirmationMethod = SalesDepartmentServiceGrpc.getOrderConfirmationMethod) == null) {
      synchronized (SalesDepartmentServiceGrpc.class) {
        if ((getOrderConfirmationMethod = SalesDepartmentServiceGrpc.getOrderConfirmationMethod) == null) {
          SalesDepartmentServiceGrpc.getOrderConfirmationMethod = getOrderConfirmationMethod = 
              io.grpc.MethodDescriptor.<grpc.services.sales_department_service.Order_Request, grpc.services.sales_department_service.Order_Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "office_service.SalesDepartmentService", "order_confirmation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.sales_department_service.Order_Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  grpc.services.sales_department_service.Order_Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SalesDepartmentServiceMethodDescriptorSupplier("order_confirmation"))
                  .build();
          }
        }
     }
     return getOrderConfirmationMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SalesDepartmentServiceStub newStub(io.grpc.Channel channel) {
    return new SalesDepartmentServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SalesDepartmentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SalesDepartmentServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SalesDepartmentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SalesDepartmentServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class SalesDepartmentServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public void checkStock(grpc.services.sales_department_service.Stock_Request request,
        io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Stock_Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckStockMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Order_Request> orderConfirmation(
        io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Order_Response> responseObserver) {
      return asyncUnimplementedStreamingCall(getOrderConfirmationMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckStockMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                grpc.services.sales_department_service.Stock_Request,
                grpc.services.sales_department_service.Stock_Response>(
                  this, METHODID_CHECK_STOCK)))
          .addMethod(
            getOrderConfirmationMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                grpc.services.sales_department_service.Order_Request,
                grpc.services.sales_department_service.Order_Response>(
                  this, METHODID_ORDER_CONFIRMATION)))
          .build();
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SalesDepartmentServiceStub extends io.grpc.stub.AbstractStub<SalesDepartmentServiceStub> {
    private SalesDepartmentServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesDepartmentServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesDepartmentServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesDepartmentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public void checkStock(grpc.services.sales_department_service.Stock_Request request,
        io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Stock_Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Order_Request> orderConfirmation(
        io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Order_Response> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getOrderConfirmationMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SalesDepartmentServiceBlockingStub extends io.grpc.stub.AbstractStub<SalesDepartmentServiceBlockingStub> {
    private SalesDepartmentServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesDepartmentServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesDepartmentServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesDepartmentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public grpc.services.sales_department_service.Stock_Response checkStock(grpc.services.sales_department_service.Stock_Request request) {
      return blockingUnaryCall(
          getChannel(), getCheckStockMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static final class SalesDepartmentServiceFutureStub extends io.grpc.stub.AbstractStub<SalesDepartmentServiceFutureStub> {
    private SalesDepartmentServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SalesDepartmentServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SalesDepartmentServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SalesDepartmentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * rpc method for bidirectional streaming calls
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<grpc.services.sales_department_service.Stock_Response> checkStock(
        grpc.services.sales_department_service.Stock_Request request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckStockMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_STOCK = 0;
  private static final int METHODID_ORDER_CONFIRMATION = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SalesDepartmentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SalesDepartmentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_STOCK:
          serviceImpl.checkStock((grpc.services.sales_department_service.Stock_Request) request,
              (io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Stock_Response>) responseObserver);
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
        case METHODID_ORDER_CONFIRMATION:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.orderConfirmation(
              (io.grpc.stub.StreamObserver<grpc.services.sales_department_service.Order_Response>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SalesDepartmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SalesDepartmentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return grpc.services.sales_department_service.HRDepartmentServiceImpl.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SalesDepartmentService");
    }
  }

  private static final class SalesDepartmentServiceFileDescriptorSupplier
      extends SalesDepartmentServiceBaseDescriptorSupplier {
    SalesDepartmentServiceFileDescriptorSupplier() {}
  }

  private static final class SalesDepartmentServiceMethodDescriptorSupplier
      extends SalesDepartmentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SalesDepartmentServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SalesDepartmentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SalesDepartmentServiceFileDescriptorSupplier())
              .addMethod(getCheckStockMethod())
              .addMethod(getOrderConfirmationMethod())
              .build();
        }
      }
    }
    return result;
  }
}
