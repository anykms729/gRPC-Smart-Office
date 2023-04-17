package grpc.services.reserve_seat;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

public class Smart_Office_Server1 extends ReserveSeatServiceGrpc.ReserveSeatServiceImplBase {
    public List<Integer> seats;
    public List<Integer> seatsReserved;
    public int numSeats = 10;
    static int port = 50053;

    public static void main(String[] args) {
        Smart_Office_Server1 smart_office_server1 = new Smart_Office_Server1();
        try {
            Server server = ServerBuilder.forPort(port)
                    .addService(smart_office_server1)
                    .build()
                    .start();

            System.out.println("Smart Seat Service started, listening on " + port);
            testJMDNS();

            // Initialize the list of seats
            smart_office_server1.seats = new ArrayList<>();
            for (int i = 1; i <= smart_office_server1.numSeats; i++) {
                smart_office_server1.seats.add(i);
            }
            smart_office_server1.seatsReserved = new ArrayList<>();
            smart_office_server1.seatsReserved.add(0);
            server.awaitTermination();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void testJMDNS() {
        try {
            // Create a JmDNS instance
            JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

            // Register a service
            ServiceInfo serviceInfo = ServiceInfo.create("_http._tcp.local.", "example", port, "path=index.html");
            jmdns.registerService(serviceInfo);

            // Wait a bit
            Thread.sleep(20000);

            // Unregister all services
            //jmdns.unregisterAllServices();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void availableSeat(AvailableSeatRequest available_seat_request, StreamObserver<AvailableSeatResponse> responseObserver) {
        System.out.println("Receiving Seat Reservation Request " + available_seat_request.getAvailableSeatRequest());

        // Display the available seats
        System.out.println("Available seats:");
        for (int i = 0; i < numSeats; i++) {
            AvailableSeatResponse reply = AvailableSeatResponse.newBuilder().setAvailableSeatResponse(seats.get(i)).build();
            responseObserver.onNext(reply);

            try {
                //wait for a second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

    public void reserveSeat(ReserveSeatRequest reserve_seat_request, StreamObserver<ReserveSeatResponse> responseObserver) {
        int seatNum = reserve_seat_request.getReserveSeatRequest();
        String message = "";

        if (seatNum == 0) {
            message = "You choose exit option,bye!";
        } else if (seatNum < 1 || seatNum > seats.size()) {
            message = "is in an invalid range";
        } else {
            try {
                if (seatsReserved.contains(seatNum)) {
                    message = "is already occupied, please choose another seat";
                } else {
                    message = "has reserved successfully";
                    seatsReserved.add(seatNum);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ReserveSeatResponse reply = ReserveSeatResponse.newBuilder().setReserveSeatResponse(seatNum).setReserveSeatResponseMessage(message).build();
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }


    public static class Seat {
        public int seatNumber;
        public boolean reserved = false;


        public Seat(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        public void setSeatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
        }

        public void setReserved(boolean reserved) {
            this.reserved = reserved;
        }

        public int getSeatNumber() {
            return seatNumber;
        }

        public boolean isReserved() {
            return reserved;
        }

        public void reserve() {
            reserved = true;
        }

    }
}





