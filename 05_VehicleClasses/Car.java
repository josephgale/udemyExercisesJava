public class Car extends Vehicle {
    //attributes
    private boolean manual;
    private int currentGear = 0;
    private int maxGears;
    private boolean clutchIn;

    //constructors
    public Car() {
        this(1.4, true, 5);
    }

    public Car(double engineSize) {
        this(engineSize, true, 5);
    }

    public Car(double engineSize, boolean manual, int maxGears) {
        super(engineSize, 4, 200);
        this.manual = manual;
        this.maxGears = maxGears;
    }

    //getters
    public void printCurrentGear() {
        System.out.println("Current gear: " + currentGear);
    }

    public void printClutchStatus() {
        System.out.println("Clutch is in: " + clutchIn);
    }

    //setters
    public void setTransmission(boolean trans) {
        this.manual = trans;
    }

    //methods for movement
    public void pushClutch() {
        if (!manual) {
            System.out.println("You don't have a clutch!");
        } else {
            clutchIn = true;
        }
    }

    public void releaseClutch() {
        if (!manual) {
            pushClutch();
        } else {
            clutchIn = false;
            System.out.println("You have released the clutch. Start moving!");
        }
    }

    public void switchGears(int amount) {
        if (!manual) {
            System.out.println("You have an automatic transmission. " +
                    "Switching gears will be taken care of for you");
        } else {
            if (!clutchIn) {
                System.out.println("Grinding gears. Push your clutch in.");
            } else {
                if ((currentGear - amount < -1) || (currentGear + amount > maxGears)) {
                    System.out.println("Out of gear range");
                } else {
                    currentGear += amount;
                    System.out.println("You successfully changed gears. You are in gear " + currentGear +
                            ".");
                }
            }
        }
    }


    int maxGearSpeed = 0;
    int minGearSpeed = 0;

    public void move(int speed) {
        if (!manual) {
            super.move(speed);
        } else {
            if (!clutchIn && currentGear != 0) {
                switch (currentGear) {
                    case -1:
                        minGearSpeed = 1;
                        maxGearSpeed = 10;
                        break;
                    case 1:
                        minGearSpeed = 1;
                        maxGearSpeed = 20;
                        break;
                    case 2:
                        minGearSpeed = 15;
                        maxGearSpeed = 35;
                        break;
                    case 3:
                        minGearSpeed = 30;
                        maxGearSpeed = 50;
                        break;
                    case 4:
                        minGearSpeed = 45;
                        maxGearSpeed = 110;
                        break;
                    case 5:
                        minGearSpeed = 60;
                        maxGearSpeed = 180;
                        break;
                }
            }
            if (speed > maxGearSpeed || speed < minGearSpeed) {
                System.out.println("Your speed is out of range for the gear. Try again.");
            } else if (currentGear == 0) {
                System.out.println("Loud roar. Put car into gear.");
            } else if (clutchIn) {
                System.out.println("Loud roar. Release clutch.");
            } else {
                super.move(speed);
            }
        }
    }

    @Override
    public void stop() {
        if (manual) {
            clutchIn = true;
            currentGear = 0;
        }
        super.stop();
    }
}
