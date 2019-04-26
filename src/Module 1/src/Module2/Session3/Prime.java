package Module2.Session3;

import java.util.Scanner;

public class Prime {

    public static String ifPrime(int num) {
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                return "Not a prime";
            }
        }
        return "Prime";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(ifPrime(number));
    }
}
