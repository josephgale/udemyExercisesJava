import java.util.Scanner;

public class InputChallenge {
    public static void main(String[] args){
        int count = 1;
        double sum = 0;
        while(count<11){
            Scanner input = new Scanner(System.in);
            System.out.println("Enter integer " + count + ":");
            boolean integerTest = input.hasNextInt();
            if(integerTest){
                int inputNumber = input.nextInt();
                sum += inputNumber;
            } else {
                System.out.println("Invalid entry");
                continue;//starts loop over without going to count++
            }
            count++;
        }
        System.out.println("The sum is " + sum);
    }

}


