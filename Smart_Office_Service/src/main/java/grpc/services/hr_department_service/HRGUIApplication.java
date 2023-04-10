package grpc.services.hr_department_service;

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

public class HRGUIApplication {
    private static HRDepartmentServiceGrpc.HRDepartmentServiceBlockingStub blockingStub;
    private static HRDepartmentServiceGrpc.HRDepartmentServiceStub asyncStub;
    private ServiceInfo hrDepartmentService;
    private JFrame frame;
    private JFrame frame2;


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
                    System.out.println("HR Department Service resolved: " + event.getInfo());
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
                    System.out.println("HR Department Service removed: " + event.getInfo());
                }

                @Override
                public void serviceAdded(ServiceEvent event) {
                    System.out.println("HR Department Service added: " + event.getInfo());
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
        frame.setTitle("HR Department Smart Service | Weekly Working Hour");
        frame.setBounds(200, 200, 380, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel[] labels = {new JLabel("Monday", JLabel.RIGHT), new JLabel("Tuesday", JLabel.RIGHT), new JLabel("Wednesday", JLabel.RIGHT), new JLabel("Thursday", JLabel.RIGHT), new JLabel("Friday", JLabel.RIGHT)};
        JTextField[] textFields = new JTextField[labels.length];
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 8, 8, 8));

        JButton btnWeeklyWorkingHour = new JButton("Weekly Working hours");
        JButton btnMonthlyPayroll = new JButton("Monthly Payroll");

        btnPanel.add(btnWeeklyWorkingHour);
        btnPanel.add(btnMonthlyPayroll);

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
        container.setBorder(new EmptyBorder(15, 15, 15, 5));
        container.add(wrapper, BorderLayout.SOUTH);
        addToCenterOfFrame1(container);
        JPanel jPanel = new JPanel();


        btnWeeklyWorkingHour.addActionListener(e -> {
            JFrame frame3 = new JFrame();
            // Accumulated hour as the day goes by
            int monday = Integer.parseInt(textFields[0].getText());
            int tuesday = Integer.parseInt(textFields[1].getText());
            int wednesday = Integer.parseInt(textFields[2].getText());
            int thursday = Integer.parseInt(textFields[3].getText());
            int friday = Integer.parseInt(textFields[4].getText());

            StreamObserver<WeeklyWorkingHourResponse> responseObserver = new StreamObserver<>() {

                @Override
                public void onNext(WeeklyWorkingHourResponse response) {
                    frame.setVisible(false);
                    frame3.setVisible(true);
                    frame3.setBounds(100, 100, 600, 150);
                    frame3.setTitle("HR Department Smart Service | Weekly Working Hour");
                    jPanel.add(new JLabel(response.getWeeklyWorkingHourMessage()));
                    frame3.add(jPanel);
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
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setMondayWorkingHour(monday).setDayCount(1).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setTuesdayWorkingHour(tuesday).setDayCount(2).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setWednesdayWorkingHour(wednesday).setDayCount(3).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setThursdayWorkingHour(thursday).setDayCount(4).build());
                requestObserver.onNext(WeeklyWorkingHourRequest.newBuilder().setFridayWorkingHour(friday).setDayCount(5).build());

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
            initialize2();
        });
    }

    private void initialize2() {
        frame.setVisible(false);
        frame2 = new JFrame();
        frame2.setVisible(true);
        frame2.setTitle("HR Department Smart Service | Monthly Payroll");
        frame2.setBounds(100, 100, 300, 150);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel[] labels = {new JLabel("Normal Working Hours", JLabel.RIGHT), new JLabel("Holiday Pay Working Hours", JLabel.RIGHT), new JLabel("Overtime Working Hours", JLabel.RIGHT)};
        JTextField[] textFields = new JTextField[labels.length];
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        JPanel labelPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel fieldPanel = new JPanel(new GridLayout(labels.length, 1));
        JPanel btnPanel = new JPanel(new GridLayout(1, 2));

        JButton btnOkay = new JButton("OK");
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
        addToCenterOfFrame2(container);

        btnOkay.addActionListener(e1 -> {
            StreamObserver<Monthly_Payroll_Response> responseObserver = new StreamObserver<>() {
                @Override
                public void onNext(Monthly_Payroll_Response response) {
                    frame2.setVisible(false);
                    JFrame frame3 = new JFrame();
                    JOptionPane.showMessageDialog(frame3, response.getMonthlyPayrollMessage());
                }

                @Override
                public void onError(Throwable t) {
                    t.printStackTrace();
                }

                @Override
                public void onCompleted() {
                    System.out.println("Client Stream Service is completed ... Receiving Monthly Payroll");
                }
            };

            StreamObserver<Monthly_Payroll_Request> requestObserver = asyncStub.inputHour(responseObserver);
            try {
                requestObserver.onNext(Monthly_Payroll_Request.newBuilder().setNormalWorkingHour(Integer.parseInt(textFields[0].getText())).build());
                Thread.sleep(500);

                requestObserver.onNext(Monthly_Payroll_Request.newBuilder().setHolidayPayWorkingHour(Integer.parseInt(textFields[1].getText())).build());
                Thread.sleep(500);

                requestObserver.onNext(Monthly_Payroll_Request.newBuilder().setOvertimeWorkingHour(Integer.parseInt(textFields[2].getText())).build());
                Thread.sleep(500);

                // Mark the end of requests
                requestObserver.onCompleted();
                Thread.sleep(10000);

            } catch (RuntimeException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        btnExit.addActionListener(e2 ->

        {
            frame2.setVisible(false);
        });
    }

    protected void addToCenterOfFrame1(Component guiComponent) {
        frame.add(guiComponent, BorderLayout.CENTER);
    }

    protected void addToCenterOfFrame2(Component guiComponent) {
        frame2.add(guiComponent, BorderLayout.CENTER);
    }

}

