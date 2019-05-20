import java.util.ArrayList;

public class Customer {
    private String name;
    private int accountNumber;
    private double accountBalance;
    private ArrayList<Double> transactions;

    public Customer(String name, int accountNumber) {
        this.name = name;
        this.accountNumber = accountNumber;
        transactions = new ArrayList<>();
        this.accountBalance = getAccountBalance();
    }

    //transaction methods:
    public void addTransaction(Double amount){
        if(amount<0&&accountBalance+amount<0){
            System.out.println("You can't take that much out");
        }else{
            accountBalance += amount;
            transactions.add(amount);
            if(amount<0){
                System.out.printf(name + " withdrew $%.2f\n", Math.abs(amount));
            }else{
                System.out.printf(name + " deposited $%.2f\n",amount);
            }
        }
    }

    public void printTransactions(){
        System.out.println("Transactions:");
        for(int i=0;i<transactions.size();i++){
            System.out.println(transactions.get(i));
        }
    }

    public double getAccountBalance(){
        double sum = 0;
        for(int i = 0;i<transactions.size();i++){
            sum+=transactions.get(i);
        }
        return sum;
    }

    public void printAccountBalance(){
        System.out.printf("Account Balance: $%.2f\n" , getAccountBalance());
    }

    //factory method to be employed from Branch:
    public static Customer createCustomer(String name, int account){
        return new Customer(name,account);
    }

    //getters and setters:
    public String getName() {
        return name;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }


}
