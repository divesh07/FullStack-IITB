import java.util.Scanner;

public class StringChar {
	public static void main(String args[]) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string  ");
		String inputstring = scan.next();
		int position = 0;
		
		while (position < inputstring.length()) {
			System.out.println("Character at position  " + position + " is " + inputstring.charAt(position));
			position = position + 1;
		}

	}
}
