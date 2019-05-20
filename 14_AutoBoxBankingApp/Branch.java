import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    //constructor
    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    //getters

    public String getName() {
        return name;
    }

    //add customers:
    public void addCustomer(String name, int account){
        //Customer newCustomer = new Customer(name,account);
        customers.add(Customer.createCustomer(name,account));
    }

    //add branch:
    public static Branch addBranch(String name){
        return new Branch(name);
    }


    //see transactions of customer
    public void getCustomerTransactions(String name){
        if(getCustomer(name)==null){
            System.out.println("No such customer exists");
        } else {
            getCustomer(name).printTransactions();
        }
    }

    public void getCustomerTransactions(int acctNumber){
        if(getCustomer(acctNumber)==null){
            System.out.println("No such customer exists");
        } else {
            getCustomer(acctNumber).printTransactions();
        }
    }

    //find customers:
    private Customer getCustomer(String name){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getName().equals(name)){
                return customers.get(i);
            }
        }return null;
    }


    private Customer getCustomer(int acctNumber){
        for(int i=0;i<customers.size();i++){
            if(customers.get(i).getAccountNumber()==acctNumber) {
                return customers.get(i);
            }
        }return null;
    }

    public void printCustomerList(){
        for(int i=0;i<customers.size();i++){
            System.out.printf("Name: " + customers.get(i).getName() +
                                "\nAccountNumber: " + customers.get(i).getAccountNumber() +
                                "\nBalance: $%.2f\n",customers.get(i).getAccountBalance());
        }
    }

    public void addTransaction(String name, double amount){
        if(getCustomer(name)!=null){
            getCustomer(name).addTransaction(amount);
        } else{
            System.out.println("Customer not found");
        }

    }

    public void addTransaction(int acctNumber, double amount){
        if(getCustomer(acctNumber)!=null){
            getCustomer(acctNumber).addTransaction(amount);
        }else{
            System.out.println("Account number not found");
        }

    }
    //get details of branch
    private double getWorth(){
        double worth = 0;
        for(int i=0;i<customers.size();i++){
          worth += customers.get(i).getAccountBalance();
        }
        return worth;
    }
    public void printReport(){
        System.out.printf("Present value: $%.2f\n", getWorth());
        System.out.println("Number of Customers: " + customers.size());
    }

}
