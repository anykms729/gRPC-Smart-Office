package grpc.services.sales_department_service;


import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Smart_Office_Server3 extends SalesDepartmentServiceGrpc.SalesDepartmentServiceImplBase {
    Map<String, Integer> stockList = new HashMap<>();
    List<String> deliveryArea = new ArrayList<>();

    public static void main(String[] args) {
        grpc.services.sales_department_service.Smart_Office_Server3 smart_office_server3 = new grpc.services.sales_department_service.Smart_Office_Server3();
        int port = 50055;
        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(smart_office_server3)
                    .build()
                    .start();

            System.out.println("Smart_Office_Server3 started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public int searchInHashMap(String productType) {
        Integer productQuantity;

        stockList.put("A Product", 30);
        stockList.put("B Product", 40);
        stockList.put("C Product", 60);
        stockList.put("D Product", 19);
        stockList.put("E Product", 77);
        stockList.put("F Product", 84);

        if (stockList.containsKey(productType)) {
            productQuantity = stockList.get(productType);
        } else
            productQuantity = 0;
        return productQuantity;
    }

    public void checkStock(StockRequest stockRequest, StreamObserver<StockResponse> responseObserver) {

        String stockProduct = stockRequest.getStockRequestProductType();
        String stockMessage = "";

        if (stockProduct.isBlank()) {
            stockMessage = "Please enter product name!";
        } else {
            try {
                if (searchInHashMap(stockProduct) != 0) {
                    stockMessage = searchInHashMap(stockProduct) + " units of " + stockProduct + " are in stock";
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
        deliveryArea.add("Dublin A");
        deliveryArea.add("Dublin B");
        deliveryArea.add("Dublin C");
        deliveryArea.add("Dublin D");
        deliveryArea.add("Dublin E");

        return new StreamObserver<>() {
            @Override
            public void onNext(OrderRequest request) {
                String orderConfirmationMessage = "";
                try {
                    if (!request.getDeliveryArea().isBlank() && !request.getProductName().isBlank() && request.getProductQuantity() > 0) {
                        if (!stockList.containsKey(request.getProductName())) {
                            orderConfirmationMessage = "Entered Product name doesn't exist in our stock, sorry!";
                        }
                        else if (stockList.get(request.getProductName()) < request.getProductQuantity()) {
                            orderConfirmationMessage = "Required Quantity is more than available stock quantity!";
                        }
                        else if (!deliveryArea.contains(request.getDeliveryArea())) {
                            orderConfirmationMessage = "Entered delivery Area is not a valid area, sorry!";
                        }
                        else {
                            orderConfirmationMessage = request.getProductName()+" will be delivered to "+request.getDeliveryArea();
                        }
                    } else {
                        orderConfirmationMessage = "Please check your order again, field can't be empty neither quantity can't be 0!";
                    }

                } catch (
                        Exception e) {
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
//                myWorkingHour.clear();
            }
        }

                ;
    }
}

