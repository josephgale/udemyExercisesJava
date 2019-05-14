public class Main {

    public static void main(String[] args) {
        Burger burger = new Burger();
        burger.addBacon();
        burger.addCheese();
        burger.addLettuce();
        burger.addTomato();
        burger.setBun("wheAT");//program should correct case
       // burger.getTotal();

        HealthyBurger myBurger = new HealthyBurger();
        myBurger.addBacon();
        myBurger.addCheese();
        myBurger.addLettuce();
        myBurger.addTomato();
        myBurger.addAvocado();
        myBurger.addSprouts();
       // myBurger.getTotal();

        DeluxeBurger kingBurger = new DeluxeBurger();
        kingBurger.setBun("white");
        kingBurger.addBacon();
        kingBurger.getTotal();

    }
}
