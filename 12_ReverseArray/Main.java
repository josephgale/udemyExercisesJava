import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //test arrays:
        int[] myArray = {1,2,3,4,5};
        System.out.println("Original Array:");
        printArray(myArray);
        reverse(myArray);
        System.out.println("\nReversed Array:");
        printArray(myArray);
    }
    
    private static void reverse(int[] array){
        int swap;
        for(int i=0;i<array.length/2;i++){
            swap = array[i];
            array[i]=array[array.length-1-i];
            array[array.length-1-i]=swap;
        }
    }
    
    private static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Index " + i + ": " + array[i]);
        }
    }
}
