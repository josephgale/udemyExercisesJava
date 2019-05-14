import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] inputArray = getIntegers(5);
        //printArray(inputArray);
        int[] mySortedArray = sortArray(inputArray);
        printArray(mySortedArray);
    }

    public static int[] getIntegers(int number){
        int[] tempArray = new int[number];
        for(int i=0;i<number;i++){
            System.out.println("Enter a number: \r");
            tempArray[i] = scanner.nextInt();
        }
        return tempArray;
    }
    public static void printArray(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.println("Index " + i + ": " + array[i]);
        }
    }
    //sort array
    public static int[] sortArray(int[] array){
        int[]sortedArray = array;
        boolean flag = true;
        int temp;
        while(flag){
            flag = false;
            for(int i=0;i<sortedArray.length-1;i++){
                if(sortedArray[i]<sortedArray[i+1]){
                    temp = sortedArray[i];
                    sortedArray[i]=sortedArray[i+1];
                    sortedArray[i+1]=temp;
                    flag=true;
                }
            }
        }
        return sortedArray;
    }


}
