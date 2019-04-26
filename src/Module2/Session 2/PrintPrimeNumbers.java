import java.util.Scanner;

public class PrintPrimeNumbers {

    public static void main(String[] args) {

        for (int num = 2; num <= 1000; num++) // Outer for-loop to get numbers from 2 to 1000
        {
            boolean primecheck = true;
            for (int i = 2; i <= Math.sqrt(num); i++) // Inner for-loop to check if each number from the outer loop is a prime
            {
                // condition for non-prime numbers
                if (num % i == 0) {
                    primecheck = false;
                    break;
                }
            }

            if (primecheck == true) {
                System.out.println(num);
            }
        }
    }
}