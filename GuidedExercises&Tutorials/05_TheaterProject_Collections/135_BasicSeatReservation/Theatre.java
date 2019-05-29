package com.udemy;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    //constructor
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        /*
            >> int lastRow: uses a char value + entered integer; endpoint for rows, which are lettered A to value entered
            >> char row: just used for populating rows with for loop. Char variables can be used to calculate integers,
                but Strings cannot.
            >> int seatNum: just used in the nested for loop for populating seats
            >> Seat(String seatNumber): ultimately a string is the parameter for a seat. Once the String is set, it must
                use compare methods which compare strings. seatNum needed to be formatted into a string and added to
                a char before it was ready to be passed into Seat parameter. To convert an int into a string, use
                String.format("%02d",intVariable)
            >> Lexographical rules:
                Closest to beginning of alphabet:
                1. Numbers (1A appears before A1)
                    a. 1 is a greater value than 01
                2. Capital letters (A appears before a)
                3. Lowercase letters
         */

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName()
    {
        return theatreName;
    }

    //=====================================================
    //validation for reserved seats is done in main method and prints that seat is taken if invalid seat entered
    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = null;
        for(Seat seat : seats) {
            //check each seat to see if it refers to seatNumber you're trying to reserve
            if(seat.getSeatNumber().equals(seatNumber)) {
                //if there is a match, put than match into a seat object for comparison later
                requestedSeat = seat;
                break;
            }
        }

        if(requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }

        return requestedSeat.reserve();
        //by returning this .reserve() function, we are killing two bird with one stone... we are sending back a true
        //or false on whether the seat was reserved using the reserve function, and the function below changes the
        //reservation status of the seat.
    }
    //==========================================================

    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    private class Seat {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        public String getSeatNumber() {
            return seatNumber;
        }
    }

}
