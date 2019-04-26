package Module2.Session3;
import java.util.Scanner;

public class SquaresOfSum {

    public static int squareOfSum(int num1, int num2){
        return ( (num1 * num1) + (num2 * num2) + (2 * num1 * num2) );
    }

    public static void main(String[] args) {
        //program that takes two numbers as input and returns the square of their sum.
        // input a , input b , ( a+b ) square

        Scanner scan = new Scanner(System.in);
        // Enter the numbers in the input console
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();
        System.out.print(squareOfSum(number1, number2));
    }
}
