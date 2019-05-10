public class Main {

    public static void main(String[] args) {
	    VIPCustomer customer1 = new VIPCustomer();
        System.out.println(customer1.getName());

        VIPCustomer customer2 = new VIPCustomer("Jane Doe",50000);
        System.out.println(customer2.getEmail());

        VIPCustomer customer3 = new VIPCustomer("Bob Brown",10000,"email@bob.com");
        System.out.println(customer3.getCreditLimit());
    }
}
