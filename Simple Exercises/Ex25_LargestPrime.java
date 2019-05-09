/*
Write a method named getLargestPrime with one parameter of type int named number. 

If the number is negative or does not have any prime numbers, the method should return -1 to indicate an invalid value.


The method should calculate the largest prime factor of a given number and return it.


EXAMPLE INPUT/OUTPUT:

* getLargestPrime (21); should return 7 since 7 is the largest prime (3 * 7 = 21)

* getLargestPrime (217); should return 31 since 31 is the largest prime (7 * 31 = 217)

* getLargestPrime (0); should return -1 since 0 does not have any prime numbers

* getLargestPrime (45); should return 5 since 5 is the largest prime (3 * 3 * 5 = 45)

* getLargestPrime (-1); should return -1 since the parameter is negative


HINT: Since the numbers 0 and 1 are not considered prime numbers, they cannot contain prime numbers.

NOTE: The method getLargestPrime should be defined as public static like we have been doing so far in the course.

NOTE: Do not add a main method to the solution code.

*/

public class LargestPrime {
    public static int getLargestPrime(int number) {
        //validate
        if(number<2){
            return -1;
        }

        //find all factors of number entered
        int count = 1;
        int potentialFactor = 0;
        while (count<number) {//exit when the count == number because no potential factors were triggered

            //find out if a number less a count is a factor
            potentialFactor = number - count;
            if(number%potentialFactor == 0){ //if your potential factor is a factor...
                //verify that number is not already prime, else Error Message
                if(potentialFactor <= 1){

                    return number;
                }
                
                //if factor is 2, there is no use running it through prime loops
                if(potentialFactor == 2){
                    //System.out.println("Highest factor went down to 2...");
                    return potentialFactor;
                }
                //find out if the factor is a prime number
                int primeCount = 1;
                int potentialPrimeFactor = 3;
                while(potentialPrimeFactor>2){

                    //reject non-prime factors
                    potentialPrimeFactor =  potentialFactor - primeCount;
                    if(potentialFactor%potentialPrimeFactor==0){
                        break;
                    }
                    //accept the first potentialFactor than cannot be evenly divided
                    if(potentialPrimeFactor==2){
                        return potentialFactor;
                    }
                 primeCount++;
                }
            }
            count ++;
        }
        return potentialFactor;//returns last value of potentialFactor
    }
    
}
