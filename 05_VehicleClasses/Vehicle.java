public class Vehicle {
    //attributes
    private double engineSize;
    private int numberWheels;
    private int maxSpeed;
    private int currentSpeed = 0;

    //constructor
    public Vehicle(double engineSize, int numberWheels, int maxSpeed) {
        this.engineSize = engineSize;
        this.numberWheels = numberWheels;
        this.maxSpeed = maxSpeed;

    }

    //methods
    public void move(int speed){
        System.out.println("Moving at " + speed + " mph");
    }
    public void turnLeft(){
        System.out.println("Turning left");
    }
    public void turnRight(){
        System.out.println("Turning right");
    }
    public void stop(){
        System.out.println("Stopping");
        currentSpeed = 0;
    }
    public int getCurrentSpeed(){
       return currentSpeed;
    }
    public void printCurrentSpeed(){
        System.out.println("Current speed: " + currentSpeed);
    }
}
