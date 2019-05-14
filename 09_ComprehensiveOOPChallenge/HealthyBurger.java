public class HealthyBurger extends Burger {
    private boolean avocado;
    private boolean sprouts;
    private String buns = "rye";
    private double total;

    double avocadoCost = 1.50;
    double sproutCost = 1.00;

    public HealthyBurger() {
    }

    public void addAvocado(){
        avocado = true;
    }
    public void addSprouts(){
        sprouts = true;
    }

    @Override
    public void setBun(String buns){
        System.out.println("You can only have rye bread with healthy burger");
    }

    private double additionalCost(){
        if(avocado){
            System.out.printf("Avocado: " + getCostFormat(),avocadoCost);
            total+=avocadoCost;
        }
        if(sprouts){
            System.out.printf("Sprouts: " + getCostFormat(),sproutCost);
            total+=sproutCost;
        }
        return total;
    }

    @Override
    public void getTotal() {
        System.out.println("Buns: " + buns);
        double totalCost = calculateCost()+additionalCost();
        System.out.printf("Total Cost: " + getCostFormat(),
                totalCost*getTaxes());
    }
}
