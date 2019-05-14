import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter an integer for array size: ");
        int count = scanner.nextInt();

        int[] userArray = readIntegers(count);
        System.out.println("The minimum integers is " + findMin(userArray));

    }

    private static int[] readIntegers(int count){
        int[] tempArray = new int[count];
        for(int i=0;i<count;i++){
            System.out.println("Enter an integer \r");
            int inputInt = scanner.nextInt();
            tempArray[i]=inputInt;
        }
        return tempArray;
    }
    private static int findMin(int[] array){
        int minInt = Integer.MAX_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]<minInt){
                minInt = array[i];
            }
        }return minInt;
    }
}
