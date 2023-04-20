package grpc.services.sales_department_service;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Smart_Office_Server3 extends SalesDepartmentServiceGrpc.SalesDepartmentServiceImplBase {
    Map<String, Integer> stockMap = new HashMap<>();
    Map<String, Integer> deliveryAreaMap = new HashMap<>();
    ArrayList<String> productNameHistory = new ArrayList<>();
    static int port = 50055;

    public static void main(String[] args) {
        grpc.services.sales_department_service.Smart_Office_Server3 smart_office_server3 = new grpc.services.sales_department_service.Smart_Office_Server3();
        smart_office_server3.stockMap.put("A Product", 40);
        smart_office_server3.stockMap.put("B Product", 32);
        smart_office_server3.stockMap.put("C Product", 60);
        smart_office_server3.stockMap.put("D Product", 19);
        smart_office_server3.stockMap.put("E Product", 77);
        smart_office_server3.stockMap.put("F Product", 84);

        // Delivery Area and delivery days taken for each area
        smart_office_server3.deliveryAreaMap.put("Dublin A", 2);
        smart_office_server3.deliveryAreaMap.put("Dublin B", 4);
        smart_office_server3.deliveryAreaMap.put("Dublin C", 3);
        smart_office_server3.deliveryAreaMap.put("Dublin D", 15);
        smart_office_server3.deliveryAreaMap.put("Dublin E", 22);


        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(smart_office_server3)
                    .build()
                    .start();

            System.out.println("Sales Department Smart Service Server started, listening on " + port);
            testJMDNS();
            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testJMDNS() {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create("_sales._tcp.local.", "SalesService", port, "path=index.html");
            jmdns.registerService(serviceInfo);

            // Wait a bit
            Thread.sleep(20000);

            // Unregister all services
            //jmdns.unregisterAllServices();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }


    public int searchProductQuantity(String productType) {
        Integer productQuantity;

        if (stockMap.containsKey(productType)) {
            productQuantity = stockMap.get(productType);
        } else
            productQuantity = 0;
        return productQuantity;
    }

    public int searchDeliveryTimeTaken(String orderArea) {
        int deliveryTimeTaken;
        if (deliveryAreaMap.containsKey(orderArea)) {
            deliveryTimeTaken = deliveryAreaMap.get(orderArea);
        } else
            deliveryTimeTaken = 0;
        return deliveryTimeTaken;
    }

    public void checkStock(StockRequest stockRequest, StreamObserver<StockResponse> responseObserver) {

        String stockProduct = stockRequest.getStockRequestProductType();
        String stockMessage = "";

        if (stockProduct.isBlank()) {
            stockMessage = "Please enter product name!";
        } else {
            try {
                if (searchProductQuantity(stockProduct) != 0) {
                    stockMessage = searchProductQuantity(stockProduct) + " units of " + stockProduct + " are in stock";
                } else if (!stockMap.containsKey(stockProduct)) {
                    stockMessage = stockProduct + " is not our Product";
                } else {
                    stockMessage = stockProduct + " is out of stock";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        StockResponse reply = StockResponse.newBuilder().setStockResponseMessage(stockMessage).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    // Bi-Direction Service
    public StreamObserver<OrderRequest> orderConfirmation(StreamObserver<OrderResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(OrderRequest request) {
                String orderConfirmationMessage = "";
                try {
                    if (request.getSetFieldName() == 1) {
                        if (deliveryAreaMap.containsKey(request.getDeliveryArea())) {
                            orderConfirmationMessage = request.getDeliveryArea() + " is available delivery area and take " + searchDeliveryTimeTaken(request.getDeliveryArea()) + " business days to be delivered";
                        } else {
                            orderConfirmationMessage = request.getDeliveryArea() + " is not available delivery area";
                        }
                    }
                    if (request.getSetFieldName() == 2) {
                        if (stockMap.containsKey(request.getProductName())) {
                            orderConfirmationMessage = request.getProductName() + " is currently in stock";
                        } else {
                            orderConfirmationMessage = request.getProductName() + " is not our product, sorry!";
                        }
                        productNameHistory.add(request.getProductName());
                    }
                    if (request.getSetFieldName() == 3) {
                        if (searchProductQuantity(productNameHistory.get(0)) > request.getProductQuantity()) {
                            orderConfirmationMessage = "Number of stock for " + productNameHistory.get(0) + " is " + searchProductQuantity(productNameHistory.get(0));
                        } else {
                            orderConfirmationMessage = "Your request for " + request.getProductQuantity() + " units of " + productNameHistory.get(0) + " is more than we have in stock or we don't have such product";
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

                OrderResponse reply = OrderResponse.newBuilder().setOrderResponseMessage(orderConfirmationMessage).build();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Order Confirmation Response has completed");

                //completed too
                responseObserver.onCompleted();
                productNameHistory.clear();
            }
        };
    }
}

