import java.util.Scanner;

public class PrimeNumber {

	public static void main(String[] args) {

		int num;
		System.out.println("Enter the number you wish to check");
		System.out.println();
		Scanner scan = new Scanner(System.in);
		num = scan.nextInt();
		boolean primecheck = true;
		for (int i = 2; i < num; i++) {

			if (num % i == 0) // condition for nonprime number
			{
				System.out.println("Not a prime");
				primecheck = false;
				break;
			}
		}

		if (primecheck == true)
			System.out.println(num + " is a prime number.");
	}
}
