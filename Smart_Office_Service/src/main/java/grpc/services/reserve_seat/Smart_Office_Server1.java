package grpc.services.reserve_seat;

import grpc.services.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Smart_Office_Server1 extends ReserveSeatServiceGrpc.ReserveSeatServiceImplBase {
    static List<Seat> seats;

    public static void main(String[] args) {
        Smart_Office_Server1 smart_office_server1 = new Smart_Office_Server1();

        int port = 50052;

        try {

            Server server = ServerBuilder.forPort(port)
                    .addService(smart_office_server1)
                    .build()
                    .start();

            System.out.println("Smart_Office_Server1 started, listening on " + port);

            server.awaitTermination();


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void reserve(ReserveSeatRequest request, StreamObserver<ReserveSeatResponse> responseObserver) {
        int numSeats = 50;

        System.out.println("Receiving Seat Reservation Request " + request.getSeatNumber());

        // Initialize the list of seats
        seats = new ArrayList<>();
        for (int i = 1; i <= numSeats; i++) {
            seats.add(new Seat(i));
        }

        // Display the available seats
        displayAvailableSeats();

        // Allow the user to reserve a seat
        boolean done = false;
        int seatNum = 0;
        while (!done) {
            System.out.print("Enter the number of the seat you want to reserve (or 0 to quit): ");
//            int seatNum = scanner.nextInt();
            seatNum = 10;

            if (seatNum == 0) {
                done = true;
            } else if (seatNum < 1 || seatNum > numSeats) {
                System.out.println("Invalid seat number. Please try again.");
            } else {
                Seat selectedSeat = seats.get(seatNum - 1);

                if (selectedSeat.isReserved()) {
                    System.out.println("That seat is already reserved. Please try again.");
                } else {
                    selectedSeat.reserve();
                    System.out.println("Seat " + seatNum + " has been reserved. Thank you!");
                    displayAvailableSeats();
                }
            }
        }
        // ReserveSeatResponse reply = ReserveSeatResponse.newBuilder().setResult(vaue).setMessage(msg).build();
        ReserveSeatResponse reply = ReserveSeatResponse.newBuilder().setSeatNumber(seatNum).build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    private static void displayAvailableSeats() {
        System.out.println("Available seats:");
        for (Seat seat : seats) {
            if (!seat.isReserved()) {
                System.out.print(seat.getSeatNumber() + " ");
            }
        }
        System.out.println();
    }

    private static class Seat {
        private int seatNumber;
        private boolean reserved;

        public Seat(int seatNumber) {
            this.seatNumber = seatNumber;
            this.reserved = false;
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


