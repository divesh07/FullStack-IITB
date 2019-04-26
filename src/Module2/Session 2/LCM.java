import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the numbers" + "\n");
		int number1 = scan.nextInt();
		int number2 = scan.nextInt();

		int multiple; // maximum number between number1 and number2 is stored in multiple
		
		if (number1 > number2) {
			multiple = number1;
		} else {
			multiple = number2;
		}
		boolean loopcontinue = true;
		
		while (loopcontinue == true) {
			if (multiple % number1 == 0 && multiple % number2 == 0) {
				System.out.println("The LCM of" + number1 + " and " + number2 + " is  " + multiple);
				loopcontinue = false;
			}
			multiple++;
		}
	}
}