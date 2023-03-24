package grpc.services.reserve_seat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;


import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import java.util.Iterator;

public class SeatGUIApplication {
    private static ReserveSeatServiceGrpc.ReserveSeatServiceBlockingStub blockingStub;
    private static ReserveSeatServiceGrpc.ReserveSeatServiceStub asyncStub;

    private ServiceInfo reserveSeatService;


    private JFrame frame;
    private JTextField textNumber1;
    private JTextArea textResponse;


    /**
     * Launch the application.
     */
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

    /**
     * Create the application.
     */
    public SeatGUIApplication() {
        String seat_reserve_service_type = "_seats._tcp.local.";
        discoverSeatReserveService(seat_reserve_service_type);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
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
            Thread.sleep(2000);

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


    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Client - Service Controller");
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

//        JLabel lblNewLabel_2 = new JLabel("Number 2");
//        panel_service_1.add(lblNewLabel_2);
//
//        textNumber2 = new JTextField();
//        panel_service_1.add(textNumber2);
//        textNumber2.setColumns(10);


//        JComboBox comboOperation = new JComboBox();
//        comboOperation.setModel(new DefaultComboBoxModel(new String[]{"ADDITION", "SUBTRACTION", "MULTIPLICATION", "DIVISION"}));
//        panel_service_1.add(comboOperation);


        JButton btnCalculate = new JButton("Reservation");
        btnCalculate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int num1 = Integer.parseInt(textNumber1.getText());

//                int index = comboOperation.getSelectedIndex();
//                Operation operation = Operation.forNumber(index);

                ReserveSeatRequest req = ReserveSeatRequest.newBuilder().setSeatNumber(num1).build();

                Iterator<ReserveSeatResponse> response = blockingStub.reserve(req);

//                textResponse.append("reply:" + response.getResult() + " mes:" + response.getMessage() + "\n");
//                System.out.println("res: " + response.getResult() + " mes: " + response.getMessage());
                textResponse.append("Reply: " + response.toString()+"\n");
                System.out.println("Reply: " + response.toString());


            }
        });
        panel_service_1.add(btnCalculate);

        textResponse = new JTextArea(3, 20);
        textResponse.setLineWrap(true);
        textResponse.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(textResponse);

        //textResponse.setSize(new Dimension(15, 30));
        panel_service_1.add(scrollPane);


        JPanel panel_service_2 = new JPanel();
        frame.getContentPane().add(panel_service_2);

        JPanel panel_service_3 = new JPanel();
        frame.getContentPane().add(panel_service_3);
    }
}
