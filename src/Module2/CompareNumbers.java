import java.util.Scanner;

public class CompareNumbers {
	public static void main(String args[]) {

		int number1, number2;
		System.out.println("Enter number 1 ");
		Scanner in = new Scanner(System.in); 
		number1 = in.nextInt(); // scan number 1
		System.out.println("Enter number 2 ");
		number2 = in.nextInt(); // scan number 2
		if (number1 >= number2) {
			System.out.println(number1 + " is greater than or equal to " + number2);
		} else {
			System.out.println(number2 + " is greater than " + number1);
		}
	}
}
