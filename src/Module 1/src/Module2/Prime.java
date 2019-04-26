package Module2;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int number = scan.nextInt();
        boolean isPrime = true;

        for ( int i = 2; i < Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                System.out.println("Number is not prime");
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println("Number is prime");
        }
    }
}
