public class Burger {
    private boolean tomato;
    private boolean lettuce;
    private boolean cheese;
    private boolean bacon;
    private String bun;
    private double total;

    //price list:
    private double baseCost = 3.00;
    private double tomatoCost = .50;
    private double lettuceCost = .50;
    private double cheeseCost = 1.00;
    private double baconCost = 1.50;
    private String costFormat = "$%.2f\n";
    private double taxes = 1.0625;

    public Burger() {

    }

    public void addTomato(){
        tomato = true;
    }
    public void addLettuce(){
        lettuce = true;
    }

    public void addCheese(){
        cheese = true;
    }
    public void addBacon(){
        bacon = true;
    }

    public void setBun(String type){
        if(type.toLowerCase().equals("wheat")||type.toLowerCase().equals("white")){
            bun = type;
        } else {
            System.out.println("Invalid bun type");
        }
    }

    public void getTotal(){
        System.out.println("Buns: " + bun.toLowerCase());
        calculateCost();
        System.out.printf("Your total is: " + costFormat,total*taxes);

        if(bun==null){
            System.out.println("You need to choose buns.");
        }
    }

    public double calculateCost(){
        System.out.printf("Base Price: " + costFormat,baseCost);
        total += baseCost;

        if(tomato){
            System.out.printf("Tomato: " + costFormat,tomatoCost);
            total += tomatoCost;
        }
        if(lettuce){
            System.out.printf("Lettuce: " + costFormat,lettuceCost);
            total += lettuceCost;
        }
        if(cheese){
            System.out.printf("Cheese: " + costFormat,cheeseCost);
            total+=cheeseCost;
        }
        if(bacon){
            System.out.printf("Bacon: " + costFormat,baconCost);
            total+=baconCost;
        }
        return total;


    }

    public String getCostFormat() {
        return costFormat;
    }

    public double getTaxes() {
        return taxes;
    }

    public String getBun(){
        return bun;
    }
}



