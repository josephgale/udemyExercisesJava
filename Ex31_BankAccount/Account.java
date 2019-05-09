public class Account {
    private long accountNumber;
    private String lastName;
    private String firstName;
    private String email;
    private long phoneNumber;
    private double balance;

    //getters
    public long getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }
    public String getLastName(){
        return lastName;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getName(){
        return firstName + " " + lastName;
    }
    public String getEmail() {
        return email;
    }

    //setters
    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setLastName(String name){
        this.lastName = name;
    }
    public void setFirstName(String name){
        this.firstName = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNumber(long number){
        this.phoneNumber = number;
    }
    public void addFunds(double amount){
        this.balance += amount;
    }

    //transaction methods:
    public void deductFunds(double amount){
        if(amount<0){
            System.out.println("You must enter a positive number");
        } else{
            if(amount>this.balance){
                System.out.printf("You were only able to deduct $%.2f\n",balance);
                balance = 0;
            }else{
                balance -= amount;
            }
        }
    }

    //other  methods:
    public void getInfo(){
        System.out.printf("Name: " + this.getName() +
                            " \nPhone: " + this.phoneNumber +
                            " \nEmail: " + this.email +
                            " \nAccount Number: " + this.accountNumber +
                            " \nBalance: $%.2f\n", this.balance);
    }
}
