import java.util.Scanner;

public class Errors {
	public static void main(String[] args) {
		int error;

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter error code to see in detail \n");
		System.out.print("Choose from - 404, 400, 401, 402, 403, 409, 505, 408, 500 \n");
		error = scan.nextInt();

		switch (error) {
		case 404:
			System.out.println("Not found");
			break;

		case 400:
			System.out.println("Bad request");
			break;

		case 401:
			System.out.println("Unauthorized");
			break;

		case 402:
			System.out.println("Payment required");
			break;

		case 403:
			System.out.println("Forbidden");
			break;

		case 409:
			System.out.println("Conflict");
			break;

		case 505:
			System.out.println("http version not supported");
			break;

		case 408:
			System.out.println("Request timeout");
			break;

		case 500:
			System.out.println("Internal server error");
			break;
		
		default:
			System.out.println("Unknown error");
		}
	}
}
