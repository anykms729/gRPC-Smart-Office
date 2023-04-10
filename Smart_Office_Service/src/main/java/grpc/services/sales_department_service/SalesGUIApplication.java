package grpc.services.sales_department_service;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

public class SalesGUIApplication {
    public static SalesDepartmentServiceGrpc.SalesDepartmentServiceBlockingStub blockingStub;
    public static SalesDepartmentServiceGrpc.SalesDepartmentServiceStub asyncStub;
    public ServiceInfo salesDepartmentService;

    public JTextField textNumber1;
    public JFrame frame;
    public JFrame frame2;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                grpc.services.sales_department_service.SalesGUIApplication window = new grpc.services.sales_department_service.SalesGUIApplication();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SalesGUIApplication() {
        String salesDepartment_service_type = "_sales._tcp.local.";
        discoverSalesDepartmentService(salesDepartment_service_type);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50055)
                .usePlaintext()
                .build();

        // Creates a new blocking-style stub that supports unary and streaming output calls on the service
        blockingStub = SalesDepartmentServiceGrpc.newBlockingStub(channel);
        asyncStub = SalesDepartmentServiceGrpc.newStub(channel);
        initialize();
    }

    private void discoverSalesDepartmentService(String service_type) {
        try {
            // Create an instance of JmDNS and bind it to a specific network interface given its IP-address
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            // Listen for services of a given type. The type has to be a fully qualified type name such as _http._tcp.local
            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Sales Department Service resolved: " + event.getInfo());
                    salesDepartmentService = event.getInfo();
                    int port = salesDepartmentService.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + salesDepartmentService.getNiceTextString());
                    System.out.println("\t host: " + salesDepartmentService.getHostAddresses()[0]);
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Sales Department Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Sales Department Service added: " + event.getInfo());
                }
            });

            // Wait a bit
            Thread.sleep(1000);

            jmdns.close();

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Sales Department Smart Service");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Product");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);

        JButton btnCheckStock = new JButton("Check Stock");
        panel_service_1.add(btnCheckStock);
        JButton btnOrderConfirmation = new JButton("Order Confirmation");
        panel_service_1.add(btnOrderConfirmation);

        btnCheckStock.addActionListener(e -> {
            String productType = textNumber1.getText();
            StockRequest stockRequest = StockRequest.newBuilder().setStockRequestProductType(productType).build();
            StockResponse response = blockingStub.checkStock(stockRequest);
            JFrame frame3 = new JFrame();
            JOptionPane.showMessageDialog(frame3, response.getStockResponseMessage());
            System.out.println("Unary Service is completed ...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException Ie) {
                // TODO Auto-generated catch block
                Ie.printStackTrace();
            }
        });

        btnOrderConfirmation.addActionListener(e -> {
            initialize2();
        });
    }

    private void initialize2() {
        frame.setVisible(false);
        frame2 = new JFrame();
        frame2.setVisible(true);
        frame2.setTitle("Sales Department Smart Service | Order Confirmation");
        frame2.setBounds(100, 100, 300, 150);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel[] labels = {new JLabel("Delivery Area", JLabel.RIGHT), new JLabel("Product Type", JLabel.RIGHT), new JLabel("Product Quantity", JLabel.RIGHT)};
        JTextField[] textFields = new JTextField[labels.length];
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));

        JButton btnOkay = new JButton("Confirm");
        JButton btnExit = new JButton("Exit");

        btnPanel.add(btnOkay);
        btnPanel.add(Box.createVerticalGlue());
        btnPanel.add(btnExit);

        container.add(labelPanel, BorderLayout.WEST);
        container.add(fieldPanel, BorderLayout.CENTER);

        for (int i = 0; i < labels.length; i++) {
            textFields[i] = new JTextField(10);
            labels[i].setLabelFor(textFields[i]);
            labelPanel.add(labels[i]);

            JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
            p.add(textFields[i]);
            fieldPanel.add(p);
        }

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(btnPanel);
        wrapper.setBorder(new EmptyBorder(10, 10, 10, 10));
        container.add(wrapper, BorderLayout.SOUTH);
        addToCenter(container);

        btnOkay.addActionListener(e1 -> {
            StreamObserver<OrderResponse> responseObserver = new StreamObserver<>() {
                @Override
                public void onNext(OrderResponse response) {
                    frame2.setVisible(false);
                    JFrame frame4 = new JFrame();
                    JOptionPane.showMessageDialog(frame4, response.getOrderResponseMessage());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Bi-Direction Service is completed ...");
                }
            };

            StreamObserver<OrderRequest> requestObserver = asyncStub.orderConfirmation(responseObserver);
            try {
                requestObserver.onNext(OrderRequest.newBuilder().setDeliveryArea((textFields[0].getText())).setSetFieldName(1).build());
                requestObserver.onNext(OrderRequest.newBuilder().setProductName(textFields[1].getText()).setSetFieldName(2).build());
                requestObserver.onNext(OrderRequest.newBuilder().setProductQuantity(Integer.parseInt(textFields[2].getText())).setSetFieldName(3).build());

                // Mark the end of requests
                requestObserver.onCompleted();

                Thread.sleep(new Random().nextInt(1000) + 500);

            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException iee) {
                // TODO Auto-generated catch block
                iee.printStackTrace();
            }
        });

        btnExit.addActionListener(e2 ->

        {
            frame2.setVisible(false);
        });

    }

    private void addToCenter(Component guiComponent) {
        frame2.add(guiComponent, BorderLayout.CENTER);
    }

}







