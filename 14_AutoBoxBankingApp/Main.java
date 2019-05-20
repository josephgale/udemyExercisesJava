public class Main {

    public static void main(String[] args) {

        Bank wellsFargo =  new Bank("WellsFargo");
        wellsFargo.addBranch("West");
        wellsFargo.addBranch("North");
        wellsFargo.addBranch("East");
        wellsFargo.addBranch("South");
        wellsFargo.showBranches(); //all branches print out as expected

        //test customer creation, plus/minus transaction, show transactions
        wellsFargo.getBranch("West").addCustomer("Joe",123123);
        wellsFargo.getBranch("West").addTransaction("Joe", 1200);
        wellsFargo.getBranch("West").addTransaction(123123, -600);
        wellsFargo.getBranch("West").getCustomerTransactions("Joe");

        //add another customer and test whether report shows accurate numbers
        wellsFargo.getBranch("West").addCustomer("Ben",321321);
        wellsFargo.getBranch("West").addTransaction("Ben",1500);
        wellsFargo.getBranch("West").printReport();
    }
}
