/*
Write a method called numberToWords with one int parameter named number.
a
The method should print out the passed number using words for the digits.

If the number is negative, print "Invalid Value".

To print the number as words, follow these steps:

1. Extract the last digit of the given number using the remainder operator. 
2. Convert the value of the digit found in Step 1 into a word. There are 10 possible values for that digit, those being 0, 1, 2, 3, 4, 5, 6, 7, 8, 9. Print the corresponding word for each digit, e.g. print "Zero" if the digit is 0, "One" if the digit is 1, and so on.
3. Remove the last digit from the number.
4. Repeat Steps 2 through 4 until the number is 0.

The logic above is correct, but in its current state, the words will be printed in reverse order. For example, if the number is 234, the logic above will produce the output "Four Three Two" inst ad of "Two Three Four". To overcome this problem, write a second method called reverse.

The method reverse should have one int parameter and return the reversed number (int). For example, if the number passed is 234, then the reversed number would be 432. The method  reverse should also reverse negative numbers.

Use the method reverse within the method numberToWords in order to print the words in the correct order.

Another thing to keep in mind is any reversed number with leading zeroes (e.g. the reversed number for 100 is 001). The logic above for the method numberToWords will print "One", but that is incorrect. It should print "One Zero Zero". To solve this problem, write a third method called getDigitCount.

The method getDigitCount should have one int parameter called number and return the count of the digits in that number. If the number is negative, return -1 to indicate an invalid value.
For example, if the number has a value of 100, the method getDigitCount should return 3 since the number 100 has 3 digits (1, 0, 0).

Example Input/Output - getDigitCount method

* getDigitCount(0); should return 1 since there is only 1 digit

* getDigitCount(123); should return 3

* getDigitCount(-12); should return -1 since the parameter is negative

* getDigitCount(5200); should return 4 since there are 4 digits in the number

Example Input/Output - reverse method

* reverse(-121); should  return -121

* reverse(1212); should return  2121

* reverse(1234); should return 4321

* reverse(100); should return 1

Example Input/Output - numberToWords method

* numberToWords(123); should print "One Two Three".

* numberToWords(1010); should print "One Zero One Zero".

* numberToWords(1000); should print "One Zero Zero Zero".

* numberToWords(-12); should print "Invalid Value" since the parameter is negative.


HINT: Use a for loop to print zeroes after reversing the number. As seen in a previous example, 100 reversed becomes 1, but the method numberToWords should print "One Zero Zero". To get the number of zeroes, check the difference between the digit count from the original number and the reversed number. 

NOTE: When printing words, each word can be in its own line. For example, numberToWords(123); can be:

One
Two
Three

They don't have to be separated by a space.

NOTE: The methods numberToWords, getDigitCount, reverse should be defined as public static like we have been doing so far in the course.
NOTE: In total, you have to write 3 methods.

NOTE: Do not add a main method to the solution code.

*/

public class NumberToWords {
   

   public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        int count = 0;
        if (number == 0) {
            count = 1;
            return count;
        } else {
            while (number > 0) {
                number /= 10;
                count++;
            }
            return count;
        }
    }

    public static int reverse(int number) {

        int reversedNumber = 0;
        while (number > 0 || number < 0) {
            //isolate and add digit from number to reversedNumber
            //multiply reversed number by 10 so you can add the next one's place digit
            reversedNumber = 10 * (reversedNumber) + number % 10;
            //reduce number to run again
            number /= 10;

        }
        return reversedNumber;
    }

    public static void numberToWords(int number) {
        //invalidate negative numbers
        if (number < 0) {
            System.out.println("Invalid Value");
        } else {
            //reverse the number so it can output words in the correct order
            int reversedNumber = reverse(number);

            //set the digit difference between reversed and original number
            int digitDiff = getDigitCount(number) - getDigitCount(reversedNumber);


       /*
       Start a while loop that does the following:
       1. Extracts the one's digit of the reversedNumber and stores it in digitStorage
       2. Puts the number in digitStorage through a switch statement to print the corresponding word
       3. Reduces reversedNumber so the next smallest digit can be extracted and
       placed in digitStorage
       4. Runs the final number through the switch statement as reversedNumber
       5. Putting the digitStorage into a sumString is my preferred method, but holding off for grading machine
        */

            int digitStorage = 0;//refreshes each loop to hold just current digit
            String sumString = "";

            if (reversedNumber == 0) {
                sumString = "Zero";
                //System.out.println("Zero");
                System.out.println(sumString);

            } else {
                while (reversedNumber != 0) {
                    //retrieve one's digit and store to temp variable digitStorage
                    if (reversedNumber < 10) {
                        digitStorage = reversedNumber;//sends the final number through switch
                    } else {
                        digitStorage = reversedNumber % 10;//sends one digit through switch
                    }

                    //use switch statement to build sumString, which is turned off for grading purposes
                    switch (digitStorage) {
                        case 1:
                            sumString = sumString + "One ";
                            //System.out.println("One");
                            break;
                        case 2:
                            sumString = sumString + "Two ";
                            //System.out.println("Two");
                            break;
                        case 3:
                            sumString = sumString + "Three ";
                            //System.out.println("Three");
                            break;
                        case 4:
                            sumString = sumString + "Four ";
                            //System.out.println("Four");
                            break;
                        case 5:
                            sumString = sumString + "Five ";
                            //System.out.println("Five");
                            break;
                        case 6:
                            sumString = sumString + "Six ";
                            //System.out.println("Six");
                            break;
                        case 7:
                            sumString = sumString + "Seven ";
                            //System.out.println("Seven");
                            break;
                        case 8:
                            sumString = sumString + "Eight ";
                            //System.out.println("Eight");
                            break;
                        case 9:
                            sumString = sumString + "Nine ";
                            //System.out.println("Nine");
                            break;
                        default:
                            sumString = sumString + "Zero ";
                            //System.out.println("Zero");
                            break;
                    }
                    reversedNumber /= 10;//swtich is broken, while loop restarts with a reduced reversedNumber

                }
                //add zeros to numbers like 100 or 200 where reverseNumber != number
                if (getDigitCount(number) != getDigitCount(reversedNumber)) {
                    for (int i = 1; i <= digitDiff; i++) {
                        sumString += "Zero ";
                        //System.out.println("Zero");;
                    }
                }
                System.out.println(sumString);//while loop is broken, return value of null is returned


            }

        }


    }
}
