import java.util.Scanner;

public class MinMaxChallenge {
    public static void main(String[] args){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Enter an integer (type invalid number to quit)");
            boolean validInput = scanner.hasNextInt();
            if(!validInput){
                break;
            }
            int userInput = scanner.nextInt();

            if(userInput>max){
                max = userInput;
            }
            if(userInput<min){
                min = userInput;
            }

        }
        scanner.close();
        System.out.println("Max integer entered: " + max);
        System.out.println("Min integer entered: " + min);
    }
}

