package Module2;
import java.util.Scanner;

public class PrintStr {
    public static void main(String[] args) {
        //Write a code that takes a string as input and then prints the characters of the string in reverse order.
        Scanner scan = new Scanner(System.in);
        // Enter the string
        String inputString = scan.next();
        int index = inputString.length() - 1; // starting point

        while (index >= 0) {
            System.out.print(inputString.charAt(index) + " ");

            // increment/decrement
            index--;
        }
        scan.close();

    }
}
