package grpc.services.reserve_seat;

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

public class SeatGUIApplication {
    private static ReserveSeatServiceGrpc.ReserveSeatServiceBlockingStub blockingStub;
    private static ReserveSeatServiceGrpc.ReserveSeatServiceStub asyncStub;
    private ServiceInfo reserveSeatService;
    public JFrame frame;
    public JFrame frame2;


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
        frame.setTitle("Smart Seat Service | Reserve Seat");
        frame.setBounds(100, 100, 480, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel[] labels = {new JLabel("Reserve", JLabel.LEFT)};
        JTextField[] textFields = new JTextField[labels.length];
        JPanel container = new JPanel();
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 8, 8, 8));

        JButton btnAvailableSeat = new JButton("Check Available Seat");
        JButton btnReserve = new JButton("Reserve Seat");

        btnPanel.add(btnAvailableSeat);
        btnPanel.add(btnReserve);

        container.add(labelPanel, BorderLayout.WEST);
        container.add(fieldPanel, BorderLayout.CENTER);

        for (int i = 0; i < labels.length; i++) {
            textFields[i] = new JTextField(10);
            labels[i].setLabelFor(textFields[i]);
            labelPanel.add(labels[i]);

            JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            p.add(textFields[i]);
            fieldPanel.add(p);
        }

        JPanel wrapper = new JPanel(new GridBagLayout());
        wrapper.add(btnPanel);
        container.setBorder(new EmptyBorder(15, 15, 15, 5));
        container.add(wrapper, BorderLayout.SOUTH);
        addToCenterOfFrame1(container);

        btnReserve.addActionListener(e -> {

            int seatRequest = Integer.parseInt(textFields[0].getText());
            ReserveSeatRequest reserveSeatRequest = ReserveSeatRequest.newBuilder().setReserveSeatRequest(seatRequest).build();
            ReserveSeatResponse response = blockingStub.reserveSeat(reserveSeatRequest);
            JOptionPane.showMessageDialog(container, "Seat " + response.getReserveSeatResponse() + " " + response.getReserveSeatResponseMessage());
            System.out.println("Unary reply is completed ...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException Ie) {
                // TODO Auto-generated catch block
                Ie.printStackTrace();
            }
        });

        btnAvailableSeat.addActionListener(e -> {
            frame.setVisible(false);
            frame2 = new JFrame();
            frame2.setVisible(true);
            frame2.setTitle("Smart Seat Service | Available Seat");
            frame2.setBounds(100, 100, 480, 100);
            JPanel seatPanel = new JPanel();

            AvailableSeatRequest request = AvailableSeatRequest.newBuilder().setAvailableSeatRequest(1).build();
            StreamObserver<AvailableSeatResponse> responseObserver = new StreamObserver<>() {
                @Override
                public void onNext(AvailableSeatResponse seat) {
                    seatPanel.add(new JButton("Seat " + seat.getAvailableSeatResponse())).setBounds(5,5,5,5);
                    frame2.add(seatPanel);
                    frame2.validate();
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
            asyncStub.availableSeat(request, responseObserver);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException Ie) {
                // TODO Auto-generated catch block
                Ie.printStackTrace();
            }

        });
    }

    protected void addToCenterOfFrame1(Component guiComponent) {
        frame.add(guiComponent, BorderLayout.CENTER);
    }
}
