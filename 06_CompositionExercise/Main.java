package com.java21days;

public class Main {

    public static void main(String[] args) {
        //Create instances of classes for composition class
        Phone phone = new Phone();
        Bed bed = new Bed();
        Book book = new Book("My Life", new Genre("Biography"));
        Fan fan = new Fan(false);
        Lamp lamp = new Lamp();

        Room room = new Room(phone,bed,lamp,book,fan);

        //testing phone functionality
        System.out.println("Testing Phone Functionality:");
        room.getPhone().pickUpPhone();
        room.getPhone().setRinging(true);
        room.getPhone().pickUpPhone();
        room.getPhone().pickUpPhone();

        //testing lamp functionality
        System.out.println("\nTesting fan functionality:");
        System.out.println("The lamp is on: " + room.getLamp().isOn());
        room.getLamp().setOn(true);
        System.out.println("The lamp is on: " + room.getLamp().isOn());

        //testing prepareRoom function:
        System.out.println("\nTesting room.prepareRoom(): ");
        room.prepareRoom();
        System.out.println("\nRoom prepared. Get status:");
        room.getStatus();

    }
}
