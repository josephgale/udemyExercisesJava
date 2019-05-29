package com.udemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Theatre theatre = new Theatre("Olympian", 8, 12);
        /*
            Creating a seatCopy list...
                >> The type of list that seatCopy will be is List<Theater.Seat>, because seat is an inner class
                    and we are creating the list in the main method. It will be generic list that holds seat objects;
                >> We can insert an already made list into seatCopy by adding "theatre.seats" as a parameter. Remember
                    that seats is the ArrayList of all seats listed as an attribute of the theatre.
         */
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        //method created below:
        printList(seatCopy);


        //this block of code shows that the seatcopy points to the same object as the original arrayList. When we
        //reserve a seatCopy object, we can't re-reserve it in Theatre.
        seatCopy.get(1).reserve();
        if(theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02");
        } else {
            System.out.println("Seat already reserved");
        }

        //You can use Collections.shuffle() if you want to shuffle your list:
        Collections.shuffle(seatCopy);
        System.out.println("Printing seatCopy");
        printList(seatCopy);
        System.out.println("Printing theatre.seat");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);
        System.out.println("Min seat number is " + minSeat.getSeatNumber());
        System.out.println("Max seat number is " + maxSeat.getSeatNumber());

        sortList(seatCopy);
        System.out.println("Printing sorted seatCopy");
        printList(seatCopy);

        //This doesn't work because newList doesn't get populated:
        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats);
    }


    public static void printList(List<Theatre.Seat> list) {
        for(Theatre.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println();
        System.out.println("======================================================================");
    }

    /*
        Understanding this method: list.get(0) is compared to every other item in the list. As the j loop keeps going
        down the list to the very end, get(0) will keep getting swapped out with the smallest value. The same process happens
        for list.get(1) all the way to the end of list.
     */
    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i=0; i<list.size() -1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) >0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }













}
