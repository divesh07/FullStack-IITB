import java.util.Scanner;

public class Uppercase {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string  ");
		String inputstring = scan.nextLine(); // nextLine helps read a line as input. 
												
		int position = 0;
		int uppercasecount = 0;
		while (position < inputstring.length()) {
			char charToBeChecked = inputstring.charAt(position);
			if (Character.isUpperCase(charToBeChecked) == true) {
				uppercasecount++;
			}
			position = position + 1;
		}
		System.out.println("The number of Uppercase characters in the sentence is " + uppercasecount);
	}
}
