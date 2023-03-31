package grpc.services.reserve_seat;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class SeatGUIApplication {
    private static ReserveSeatServiceGrpc.ReserveSeatServiceBlockingStub blockingStub;
    private static ReserveSeatServiceGrpc.ReserveSeatServiceStub asyncStub;

    private ServiceInfo reserveSeatService;
    private JFrame frame;
    private JTextField textNumber1;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                SeatGUIApplication window = new SeatGUIApplication();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public SeatGUIApplication() {
        String seat_reserve_service_type = "_seats._tcp.local.";
        discoverSeatReserveService(seat_reserve_service_type);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = ReserveSeatServiceGrpc.newBlockingStub(channel);
        asyncStub = ReserveSeatServiceGrpc.newStub(channel);

        initialize();
    }


    private void discoverSeatReserveService(String service_type) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Reserve Seat Service resolved: " + event.getInfo());

                    reserveSeatService = event.getInfo();

                    int port = reserveSeatService.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + reserveSeatService.getNiceTextString());
                    System.out.println("\t host: " + reserveSeatService.getHostAddresses()[0]);
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Reserve Seat Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("Reserve Seat Service added: " + event.getInfo());
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
        frame.setTitle("Seat Reservation Service");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Seat Number");
        panel_service_1.add(lblNewLabel_1);

        textNumber1 = new JTextField();
        panel_service_1.add(textNumber1);
        textNumber1.setColumns(10);

        JButton btnReserve = new JButton("Reserve");
        panel_service_1.add(btnReserve);
        JButton btnAvailableSeat = new JButton("Available Seat");
        panel_service_1.add(btnAvailableSeat);

        btnReserve.addActionListener(e -> {
            int num1 = Integer.parseInt(textNumber1.getText());
            ReserveSeatRequest reserveSeatRequest = ReserveSeatRequest.newBuilder().setReserveSeatRequest(num1).build();
            ReserveSeatResponse response = blockingStub.reserveSeat(reserveSeatRequest);
            JOptionPane.showMessageDialog(panel_service_1, "Seat " + response.getReserveSeatResponse() + " " + response.getReserveSeatResponseMessage());
            System.out.println("Unary reply is completed ...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException Ie) {
                // TODO Auto-generated catch block
                Ie.printStackTrace();
            }
        });

        btnAvailableSeat.addActionListener(e -> {
            AvailableSeatRequest req = AvailableSeatRequest.newBuilder().setAvailableSeatRequest(1).build();
            StreamObserver<AvailableSeatResponse> responseObserver = new StreamObserver<>() {
                @Override
                public void onNext(AvailableSeatResponse seat) {
                    panel_service_1.add(new JButton("Seat " + seat.getAvailableSeatResponse()));
                    panel_service_1.validate();
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Stream is completed ... Received all available seats number");
                }
            };
            asyncStub.availableSeat(req, responseObserver);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException Ie) {
                // TODO Auto-generated catch block
                Ie.printStackTrace();
            }

            if (e.getSource() == "Next") {

            }
        });
    }

}
