package grpc.services.hr_department_service;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Smart_Office_Server2 extends HRDepartmentServiceGrpc.HRDepartmentServiceImplBase {
    List<Double> myWorkingHour = new ArrayList<>();
    double workBreak;

    public double addAllWorkingHours(ArrayList<Double> myWorkingHour) {
        double dailyWorkingHour = 0;
        for (int i = 0; i < myWorkingHour.size(); i++) {
            dailyWorkingHour += myWorkingHour.get(i) - checkWorkBreak(myWorkingHour.get(i));
        }
        return dailyWorkingHour;
    }

    public double checkWorkBreak(double workingHour) {
        if (workingHour > 6) {
            workBreak = 0.5;
        } else {
            workBreak = 0.15;
        }
        return workBreak;
    }

    public static void main(String[] args) {
        grpc.services.hr_department_service.Smart_Office_Server2 smart_office_server2 = new grpc.services.hr_department_service.Smart_Office_Server2();
        int port = 50054;
        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(smart_office_server2)
                    .build()
                    .start();

            System.out.println("HR Department Smart Service Server started, listening on " + port);

            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public StreamObserver<WeeklyWorkingHourRequest> check(StreamObserver<WeeklyWorkingHourResponse> responseObserver) {
        return new StreamObserver<>() {
            @Override
            public void onNext(WeeklyWorkingHourRequest request) {
                String weeklyWorkingHourMessage = "";

                try {
                    if (request.getDayCount() == 1) {
                        myWorkingHour.add(0, request.getMondayWorkingHour());
                        weeklyWorkingHourMessage = "Reply 1: Accumulated working hours till Monday: " + (addAllWorkingHours((ArrayList<Double>) myWorkingHour)) + " hours with Monday break " + checkWorkBreak(myWorkingHour.get(0)) + " hours";
                    }
                    if (request.getDayCount() == 2) {
                        myWorkingHour.add(1, request.getTuesdayWorkingHour());
                        weeklyWorkingHourMessage = "Reply 2: Accumulated working hours till Tuesday: " + addAllWorkingHours((ArrayList<Double>) myWorkingHour) + " hours with Tuesday break " + checkWorkBreak(myWorkingHour.get(1)) + " hours";
                    }
                    if (request.getDayCount() == 3) {
                        myWorkingHour.add(2, request.getWednesdayWorkingHour());
                        weeklyWorkingHourMessage = "Reply 3: Accumulated working hours till Wednesday: " + addAllWorkingHours((ArrayList<Double>) myWorkingHour) + " hours with Wednesday break " + checkWorkBreak(myWorkingHour.get(2)) + " hours";
                    }
                    if (request.getDayCount() == 4) {
                        myWorkingHour.add(3, request.getThursdayWorkingHour());
                        weeklyWorkingHourMessage = "Reply 4: Accumulated working hours till Thursday: " + addAllWorkingHours((ArrayList<Double>) myWorkingHour) + " hours with Thursday break " + checkWorkBreak(myWorkingHour.get(3)) + " hours";
                    }
                    if (request.getDayCount() == 5) {
                        myWorkingHour.add(4, request.getFridayWorkingHour());
                        weeklyWorkingHourMessage = "Reply 5: Accumulated working hours till Friday: " + addAllWorkingHours((ArrayList<Double>) myWorkingHour) + " hours with Friday break " + checkWorkBreak(myWorkingHour.get(4)) + " hours";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                WeeklyWorkingHourResponse reply = WeeklyWorkingHourResponse.newBuilder().setWeeklyWorkingHourMessage(weeklyWorkingHourMessage).build();
                responseObserver.onNext(reply);
            }

            @Override
            public void onError(Throwable t) {
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("Receiving Weekly Working Hour Response completed");

                //completed too
                responseObserver.onCompleted();
                myWorkingHour.clear();
            }
        };
    }

    public StreamObserver<Monthly_Payroll_Request> inputHour(StreamObserver<Monthly_Payroll_Response> responseObserver) {
        final ArrayList<Double> totalSum = new ArrayList<>();

        return new StreamObserver<>() {
            @Override
            public void onNext(Monthly_Payroll_Request request) {
                System.out.println("Receiving Monthly Working hours fall under each different category...");
                totalSum.add(request.getNormalWorkingHour() * 12.7);
                totalSum.add(request.getHolidayPayWorkingHour() * 12.7 * 1.5);
                totalSum.add(request.getOvertimeWorkingHour() * 12.7 * 1.78);
            }

            @Override
            public void onError(Throwable t) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onCompleted() {
                double temp = 0;

                System.out.printf("Receiving Monthly Payroll is completed \n");
                for (double totalSumArray : totalSum) {
                    temp += temp + totalSumArray;
                }

                String totalSum_Message = "This month you will get paid EUR" + temp;

                Monthly_Payroll_Response monthly_payroll_message = Monthly_Payroll_Response.newBuilder().setMonthlyPayrollMessage(totalSum_Message).build();

                responseObserver.onNext(monthly_payroll_message);

                responseObserver.onCompleted();
            }
        };
    }
}
