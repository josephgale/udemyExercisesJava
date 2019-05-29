package com.udemy;

import java.util.*;

/**
 * Created by dev on 2/12/2015.
 */
public class Theatre {
    private final String theatreName;
    private List<Seat> seats = new ArrayList<>();

    //regular constructor from earlier
    public Theatre(String theatreName, int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    //regular getter from earlier
    public String getTheatreName() {        
        return theatreName;
    }

    //this is the full binary search algorithm typed out that java uses:
    public boolean reserveSeat(String seatNumber) {
        int low = 0;
        int high = seats.size()-1;

        while (low <= high) {
            System.out.print(".");
            int mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            //compare middle value to typed in value:
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            //if middle value is smaller than typed in value, then raise the lower value
            // add try the algorithm again
            if (cmp < 0) {
                low = mid + 1;
                //if middle value is higher than input value, lower the high and do loop again
            } else if (cmp > 0) {
                high = mid - 1;
                //once the cmp is 0, return the seat.reserve() result;
            } else {
                return seats.get(mid).reserve();
            }
        }
        //if high variable matches low variable, the seatNumber was not found:
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    // for testing
    public void getSeats() {
        for(Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    //==================================================
    private class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        //constructor
        public Seat(String seatNumber) {
            
            this.seatNumber = seatNumber;
        }

        //implementation from interface Comparable--don't see where this is used yet
        @Override
        public int compareTo(Seat seat)
        {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }

        //regular reserve() method from earlier
        public boolean reserve() {
            if(!this.reserved) {
                this.reserved = true;
                System.out.println("Seat " + seatNumber + " reserved");
                return true;
            } else {
                return false;
            }
        }

        //regular cancel() method from earlier
        public boolean cancel() {
            if(this.reserved) {
                this.reserved = false;
                System.out.println("Reservation of seat " + seatNumber + " cancelled");
                return true;
            } else {
                return false;
            }
        }

        //regular getter
        public String getSeatNumber() {
            
            return seatNumber;
        }
    }
    //=====================================================================================

}
