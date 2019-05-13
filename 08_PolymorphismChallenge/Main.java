package com.java21days;

public class Main {

    public static void main(String[] args) {

        SportsCar corvette = new Corvette(8,"Vettie");
        SportsCar lamborghini = new Lamborghini(12,"Lammie");
        SportsCar bmw = new BMW(8,"Beamer");

        corvette.drive();
        lamborghini.drive();
        bmw.drive();
    }
}

class SportsCar {
    private int cylinders;
    private String name;
    private int wheels;
    private boolean engine;

    public SportsCar(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public void drive(){
        System.out.println("Roar");
    }


}

class Corvette extends SportsCar{
    public Corvette(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Hearing American muscle!");
    }
}

class Lamborghini extends SportsCar{
    public Lamborghini(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Hearing Italian style!");
    }
}

class BMW extends SportsCar{
    public BMW(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.println("Listen to that German engineering");
    }
}
