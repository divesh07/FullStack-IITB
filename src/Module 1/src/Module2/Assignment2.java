package Module2;
import java.util.Scanner;

public class Assignment2 {
    public static void main(String[] args) {
        // prints the sum of first n numbers, where n is the input from the use
        Scanner scan = new Scanner(System.in);
        //Enter the number upto which you wish to find the sum, in the input console
        int number = scan.nextInt();
        int sum = 0;
        for ( int i =1; i<=number; i++ ) {
            // Write your logic here
            sum += i;
        }

        System.out.print(sum);
    }
}
