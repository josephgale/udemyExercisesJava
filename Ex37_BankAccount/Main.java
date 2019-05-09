
/*
Main class demos a sample customer to ensure that all methods within
Account.java are functioning as expected.
 */

public class Main {
    public static void main(String[] args) {
        //setup account:
        Account newCustomer = new Account();
        newCustomer.setAccountNumber(100050001);
        newCustomer.setPhoneNumber(8009996363L);
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        newCustomer.setEmail("John.Doe@email.com");

        //get information
        System.out.println("The account number is: " + newCustomer.getAccountNumber());
        newCustomer.getInfo();
        System.out.println("");
        newCustomer.addFunds(1000);
        System.out.printf("The balance is: $" + "%.2f",newCustomer.getBalance());
        System.out.println(" ");
        newCustomer.deductFunds(2000);
        newCustomer.getBalance();

    }
}
