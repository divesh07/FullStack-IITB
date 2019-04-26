import java.util.Scanner;

public class Password {

	public static void main(String args[]) {
		String password = "upgrad";
		Scanner scan = new Scanner(System.in);

		boolean loopcontinue = true; // Loop Control
		while (loopcontinue == true) {
			System.out.println("Enter the password ");
			String input = scan.next();
			if (input.equals(password)) {
				System.out.println("Correct password");
				loopcontinue = false;
			} else {
				System.out.println("Password is incorrect. Try again");
			}
		}
	}
}
