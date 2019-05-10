public class Main {

    public static void main(String[] args) {
        //create charger object
        DodgeCharger charger = new DodgeCharger(6.4);

        //attempting to drive car in neutral or gear 0
        System.out.println("\nAttempting to drive in neutral or gear 0:");
        charger.printCurrentGear();
        charger.printClutchStatus();
        charger.move(25);


        //putting into gear and driving
        System.out.println("\nTesting Gears and Driving:");
        charger.switchGears(1);
        charger.pushClutch();
        charger.switchGears(1);
        charger.move(5);
        charger.releaseClutch();
        charger.move(10);
        charger.move(15);
        charger.move(25);

        //testing all gears
        System.out.println("\nTesting all gears:");
        charger.pushClutch();
        charger.switchGears(1);
        charger.releaseClutch();
        charger.move(35);
        charger.printCurrentGear();
        System.out.println(" ");
        charger.pushClutch();
        charger.switchGears(1);
        charger.releaseClutch();
        charger.move(50);
        System.out.println(" ");
        charger.pushClutch();
        charger.switchGears(2);
        charger.releaseClutch();
        charger.move(80);
        charger.move(180);
        charger.pushClutch();
        charger.switchGears(1);
        charger.releaseClutch();
        charger.move(180);

        //downshift gears
        System.out.println("\nTesting Downshifting:");
        charger.move(55);
        charger.pushClutch();
        charger.switchGears(-1);
        charger.releaseClutch();
        charger.move(55);
        charger.switchGears(-1);
        charger.pushClutch();
        charger.switchGears(-2);
        charger.releaseClutch();
        charger.move(30);
        charger.pushClutch();
        charger.switchGears(-1);
        charger.releaseClutch();
        charger.move(15);

        //testing stop and reverse
        System.out.println("\nTesting automatic transmission:");
        charger.stop();
        charger.printCurrentGear();
        charger.printClutchStatus();
        charger.printCurrentSpeed();
        charger.switchGears(-1);
        charger.releaseClutch();
        charger.move(20);
        charger.move(10);

        //testing automatic transmission
        DodgeCharger charger2 = new DodgeCharger(3.6);
        charger2.setTransmission(false);
        charger2.switchGears(1);
        charger2.pushClutch();
        charger2.move(50);
    }
}
