public class VIPCustomer {
    private String name;
    private double creditLimit;
    private String email;

    public VIPCustomer(){
        this("John Doe", 50000,"joe@email.com");
    }

    public VIPCustomer(String name, double creditLimit){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = "default@company.com";
    }

    public VIPCustomer(String name,double creditLimit,String email){
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName(){
        return name;
    }
    public double getCreditLimit(){
        return creditLimit;
    }
    public String getEmail(){
        return email;
    }

}
