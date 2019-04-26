import java.util.Scanner;

public class Calculator {

	public static void main(String args[]) {

		String operation;
		Double num1, num2, result;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter first number  ");
		num1 = in.nextDouble();
		System.out.println("Enter second number  ");
		num2 = in.nextDouble();

		System.out.println("What operation would you like the program to perform?");
		System.out.println("Enter Sum, Multiply, Subtract or Divide" + "\n");
		Scanner op = new Scanner(System.in);
		operation = op.next();
		
		String sum = "Sum";
		String multiply = "Multiply";
		String subtract = "Subtract";
		String divide = "Divide";

		if (operation.equals("Sum")) {
			result = num1 + num2;
			System.out.println("Sum of entered numbers = " + result);
		}

		if (operation.equals("Multiply")) {
			result = num1 * num2;
			System.out.println("Product of entered numbers = " + result);
		}

		else if (operation.equals("Subtract")) {
			result = num1 - num2;
			System.out.println("Difference of numbers = " + result);
		}

		else if (operation.equals("Divide")) {
			result = num1 / num2;
			System.out.println("Product of entered numbers = " + result);
		}
	}
}




/* Make the modification as is done by our expert using the code below
 
 if(num2==0) { 
   System.out.println("Division is not defined, when denominator is 0"); 
 } else {
   result = num1/num2;
   System.out.println("Dividend of entered numbers = "+result);
 }

*/
