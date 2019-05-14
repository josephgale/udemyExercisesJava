public class DeluxeBurger extends Burger {
    private boolean chips;
    private boolean drink;
    private double total;

    private double chipCost = 1.75;
    private double drinkCost = 1.00;
    private double deluxeDiscount = .50;

    public DeluxeBurger() {
        this.chips = true;
        this.drink = true;
    }

    @Override
    public void addTomato(){
        System.out.println("You can't add tomatoes");
    }

    @Override
    public void addLettuce(){
        System.out.println("You can't add lettuce");
    }

    @Override
    public void addCheese(){
        System.out.println("You can't add cheese");
    }

    @Override
    public void addBacon(){
        System.out.println("You can't add bacon");
    }


    private double additionalCost(){
       if(chips){
           System.out.printf("Chips: " + getCostFormat(),chipCost);
           total += chipCost;
       }
       if(drink){
           System.out.printf("Drink: " + getCostFormat(),drinkCost);
           total += drinkCost;
       }
       System.out.printf("Deluxe Discount: -" + getCostFormat(),deluxeDiscount);
       return total-deluxeDiscount;
    }

    @Override
    public void getTotal() {
        System.out.println("Buns: " + getBun());
        double totalCost = calculateCost()+additionalCost();
        System.out.printf("Total Cost: " + getCostFormat(),
                totalCost*getTaxes());
    }
}
