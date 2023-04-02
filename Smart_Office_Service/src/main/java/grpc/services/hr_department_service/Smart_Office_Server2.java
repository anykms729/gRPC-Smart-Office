package grpc.services.hr_department_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Smart_Office_Server2 extends HRDepartmentServiceGrpc.HRDepartmentServiceImplBase {
    List<Integer> myWorkingHour = new ArrayList<>();
    double workBreak;

    public int addAllWorkingHours(ArrayList<Integer> myWorkingHour) {
        int dailyWorkingHour = 0;
        for (int i = 0; i < myWorkingHour.size(); i++) {
            dailyWorkingHour += myWorkingHour.get(i);
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

            System.out.println("Smart_Office_Server2 started, listening on " + port);

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
                Integer statutoryWeeklyWorkingHours = 52;

                try {
                    if (request.getDayCount() == 1) {
                        myWorkingHour.add(0, request.getMondayWorkingHour());
                        checkWorkBreak(myWorkingHour.get(0));
                        weeklyWorkingHourMessage = "Your working hours till Monday: " + (addAllWorkingHours((ArrayList<Integer>) myWorkingHour)-workBreak) + " hours";
                    }
                    if (request.getDayCount() == 2) {
                        myWorkingHour.add(1, request.getTuesdayWorkingHour());
                        weeklyWorkingHourMessage = "Your working hours till Tuesday: " + addAllWorkingHours((ArrayList<Integer>) myWorkingHour) + " hours";
                    }
                    if (request.getDayCount() == 3) {
                        myWorkingHour.add(2, request.getWednesdayWorkingHour());
                        weeklyWorkingHourMessage = "Your working hours till Wednesday: " + addAllWorkingHours((ArrayList<Integer>) myWorkingHour) + " hours";
                    }
                    if (request.getDayCount() == 4) {
                        myWorkingHour.add(3, request.getThursdayWorkingHour());
                        weeklyWorkingHourMessage = "Your working hours till Thursday: " + addAllWorkingHours((ArrayList<Integer>) myWorkingHour) + " hours";
                    }
                    if (request.getDayCount() == 5) {
                        myWorkingHour.add(4, request.getFridayWorkingHour());
                        weeklyWorkingHourMessage = "Your working hours till Friday: " + addAllWorkingHours((ArrayList<Integer>) myWorkingHour) + " hours";
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

}
