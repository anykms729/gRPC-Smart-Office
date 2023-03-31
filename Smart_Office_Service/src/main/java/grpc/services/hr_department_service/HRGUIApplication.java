package grpc.services.hr_department_service;

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
import java.util.Random;

public class HRGUIApplication {
    private static HRDepartmentServiceGrpc.HRDepartmentServiceBlockingStub blockingStub;
    private static HRDepartmentServiceGrpc.HRDepartmentServiceStub asyncStub;
    private ServiceInfo hrDepartmentService;
    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JTextField textNumber3;
    private JTextField textNumber4;
    private JTextField textNumber5;


    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                grpc.services.hr_department_service.HRGUIApplication window = new grpc.services.hr_department_service.HRGUIApplication();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HRGUIApplication() {
        String hrDepartment_service_type = "_hrDepartment._tcp.local.";
        discoverHRDepartmentService(hrDepartment_service_type);

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50054)
                .usePlaintext()
                .build();

        //stubs -- generate from proto
        blockingStub = HRDepartmentServiceGrpc.newBlockingStub(channel);
        asyncStub = HRDepartmentServiceGrpc.newStub(channel);

        initialize();
    }


    private void discoverHRDepartmentService(String service_type) {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());
            jmdns.addServiceListener(service_type, new ServiceListener() {

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Reserve Seat Service resolved: " + event.getInfo());
                    hrDepartmentService = event.getInfo();
                    int port = hrDepartmentService.getPort();

                    System.out.println("resolving " + service_type + " with properties ...");
                    System.out.println("\t port: " + port);
                    System.out.println("\t type:" + event.getType());
                    System.out.println("\t name: " + event.getName());
                    System.out.println("\t description/properties: " + hrDepartmentService.getNiceTextString());
                    System.out.println("\t host: " + hrDepartmentService.getHostAddresses()[0]);
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
        frame.setTitle("HR Department Smart Service");
        frame.setBounds(100, 100, 500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BoxLayout bl = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        frame.getContentPane().setLayout(bl);

        JPanel panel_service_1 = new JPanel();
        frame.getContentPane().add(panel_service_1);
        panel_service_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        JLabel lblNewLabel_1 = new JLabel("Monday");
        JLabel lblNewLabel_2 = new JLabel("Tuesday");
        JLabel lblNewLabel_3 = new JLabel("Wednesday");
        JLabel lblNewLabel_4 = new JLabel("Thursday");
        JLabel lblNewLabel_5 = new JLabel("Friday");

        panel_service_1.add(lblNewLabel_1);
        panel_service_1.add(lblNewLabel_2);
        panel_service_1.add(lblNewLabel_3);
        panel_service_1.add(lblNewLabel_4);
        panel_service_1.add(lblNewLabel_5);

        textNumber1 = new JTextField();
        textNumber2 = new JTextField();
        textNumber3 = new JTextField();
        textNumber4 = new JTextField();
        textNumber5 = new JTextField();

        panel_service_1.add(textNumber1);
        panel_service_1.add(textNumber2);
        panel_service_1.add(textNumber3);
        panel_service_1.add(textNumber4);
        panel_service_1.add(textNumber5);

        textNumber1.setColumns(10);
        textNumber2.setColumns(10);
        textNumber3.setColumns(10);
        textNumber4.setColumns(10);
        textNumber5.setColumns(10);

        JButton btnWeeklyWorkingHour = new JButton("Weekly Working hours");
        panel_service_1.add(btnWeeklyWorkingHour);

        JButton btnMonthlyPayroll = new JButton("Monthly Payroll");
        panel_service_1.add(btnMonthlyPayroll);

        btnWeeklyWorkingHour.addActionListener(e -> {
            int request_message_count = 0;

            int monday = Integer.parseInt(textNumber1.getText());
            int tuesday = Integer.parseInt(textNumber2.getText());
            int wednesday = Integer.parseInt(textNumber3.getText());
            int thursday = Integer.parseInt(textNumber4.getText());
            int friday = Integer.parseInt(textNumber5.getText());


            StreamObserver<WeeklyWorkingHourResponse> responseObserver = new StreamObserver<WeeklyWorkingHourResponse>() {

                @Override
                public void onNext(WeeklyWorkingHourResponse response) {
                    System.out.println("Receiving Weekly Total Working Hour: " + response.getTotalWeeklyWorkingHour() + " with message: " + response.getWeeklyWorkingHourMessage());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Bidirectional service is completed ... ");
                }

            };

            StreamObserver<WeeklyWorkingHourRequest> requestObserver = asyncStub.check(responseObserver);

            try {

                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setMondayWorkingHour(monday).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setTuesdayWorkingHour(tuesday).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setWednesdayWorkingHour(wednesday).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setThursdayWorkingHour(thursday).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setFridayWorkingHour(friday).build());


                // Mark the end of requests
                requestObserver.onCompleted();


                // Sleep for a bit before sending the next one.
                Thread.sleep(new Random().nextInt(1000) + 500);


            } catch (RuntimeException re) {
                re.printStackTrace();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException iee) {
                // TODO Auto-generated catch block
                iee.printStackTrace();
            }
        });

        // Client Stream gRPC Service
        btnMonthlyPayroll.addActionListener(e -> {
            int normal_working_hour = Integer.parseInt(textNumber1.getText());
            int holiday_pay_working_hour = Integer.parseInt(textNumber2.getText());
            int overtime_working_hour = Integer.parseInt(textNumber3.getText());

        });
    }
}
