public class Main {

    public static void main(String[] args) {
        Gearbox mcLaren = new Gearbox(6);
        /*Originally, we did not create gears in constructor, but created them
        as follows:
        mcLaren.addGear(1,5.3);
        mcLaren.addGear(2,10.6);
        mcLaren.addGear(3,15.9);
        */

        /*
        The program operates as follows: operateClutch(true) for changing gears,
        operateClutch(false) for accelerating in new gear. Otherwise you get
        "Grind" or "Scream"
         */
        mcLaren.operateClutch(true);
        mcLaren.changeGear(1);
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(1000));
        mcLaren.changeGear(2);//returns grind
        System.out.println(mcLaren.wheelSpeed(3000));//returns 0


        /*
        Notice that there must be an instance of Gearbox before
        a new gear can be initialized. This example also shows
        a case where the inner class is public, whereas inner classes
        will most often be private:
        Gearbox.Gear first = mcLaren.new Gear(1,12.3);
        System.out.println(first.driveSpeed(1000));
         */
    }
}

