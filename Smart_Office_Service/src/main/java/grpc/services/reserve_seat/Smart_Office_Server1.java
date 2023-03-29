package grpc.services.reserve_seat;

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
        int port = 50053;
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

    public void availableSeat(AvailableSeatRequest available_seat_request, StreamObserver<AvailableSeatResponse> responseObserver) {
        int numSeats = 7;

        // Initialize the list of seats
        seats = new ArrayList<>();
        for (int i = 1; i <= numSeats; i++) {
            seats.add(new Seat(i));
        }

        System.out.println("Receiving Seat Reservation Request " + available_seat_request.getAvailableSeatRequest());


        // Display the available seats
        System.out.println("Available seats:");
//        for (Seat seat : seats) {
//            if (!seat.isReserved()) {
                for (int i = 1; i <= numSeats; i++) {
                    AvailableSeatResponse reply = AvailableSeatResponse.newBuilder().setAvailableSeatResponse(i).build();
                    responseObserver.onNext(reply);

                    try {
                        //wait for a second
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
//            }
//        }

        responseObserver.onCompleted();
    }


    // Allow the user to reserve a seat
//        boolean done = false;
//        int seatNum = request.getSeatNumber();
//        while (!done) {
//
//            if (seatNum == 0) {
//                done = true;
//            } else if (seatNum < 1 || seatNum > numSeats) {
//                System.out.println("Invalid seat number. Please try again.");
//            } else {
//                Seat selectedSeat = seats.get(seatNum - 1);
//
//                if (selectedSeat.isReserved()) {
//                    System.out.println("That seat is already reserved. Please try again.");
//                } else {
//                    selectedSeat.reserve();
//                    System.out.println("Seat " + seatNum + " has been reserved. Thank you!");
//                }
//            }
//        }
//        AvailableSeatResponse reply = AvailableSeatResponse.newBuilder().setSeatNumber(seatNum).build();
//
//        responseObserver.onNext(reply);
//        responseObserver.onCompleted();
}

//    private static void displayAvailableSeats() {
//        System.out.println("Available seats:");
//        for (Seat seat : seats) {
//            if (!seat.isReserved()) {
//                System.out.print(seat.getSeatNumber() + " ");
//            }
//        }
//        System.out.println();
//    }

class Seat {
    private int seatNumber;
    private boolean reserved;


    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
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




