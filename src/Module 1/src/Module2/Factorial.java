package Module2;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        int factorial = 1;

        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        for ( int i = 1 ; i <= number ; i++ ){
            factorial = factorial * i;
        }

        System.out.println(factorial);

    }
}
