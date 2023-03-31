package grpc.services.hr_department_service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class Smart_Office_Server2 extends HRDepartmentServiceGrpc.HRDepartmentServiceImplBase {

//    public int numSeats = 7;

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
                System.out.println("Receiving Weekly Working Hours Status: "
                        + request.getMondayWorkingHour()
                        + request.getTuesdayWorkingHour() + request.getWednesdayWorkingHour()
                        + request.getThursdayWorkingHour() + request.getFridayWorkingHour()
                );

                Integer totalWeeklyWorkingHour = request.getMondayWorkingHour()
                        + request.getTuesdayWorkingHour() + request.getWednesdayWorkingHour()
                        + request.getThursdayWorkingHour() + request.getFridayWorkingHour();

                try {
                    if (totalWeeklyWorkingHour > statutoryWeeklyWorkingHours) {
                        weeklyWorkingHourMessage = "Your weekly working hour " + totalWeeklyWorkingHour + "exceeds " + statutoryWeeklyWorkingHours + " hours";
                    } else {
                        weeklyWorkingHourMessage = "You can still work " + (statutoryWeeklyWorkingHours - totalWeeklyWorkingHour) + " more hours in this week";
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }

                WeeklyWorkingHourResponse reply = WeeklyWorkingHourResponse.newBuilder().setTotalWeeklyWorkingHour(totalWeeklyWorkingHour).setWeeklyWorkingHourMessage(weeklyWorkingHourMessage).build();

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
            }
        };
    }

}
