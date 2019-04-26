import java.util.Scanner;

public class TicketPrice {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter visitor's age  ");
		int age = scan.nextInt();
		double TicketPrice;
		
		if (age <= 3) {
			TicketPrice = 0;
			System.out.println("Free Entry");
		} 
		else if (age > 3 && age <= 18) {
			System.out.println("Does the visitor face any chronic disease? Enter 'y' or 'n' " + "\n");
			char ChronicDisease = scan.next().charAt(0);
			if (ChronicDisease == 'y') {
				TicketPrice = 0;
				System.out.println("Free Entry");
			} else {
				TicketPrice = 20 * 0.5;
				System.out.println("Ticket Price: " + TicketPrice);
			}
		}
		else if (age > 18 && age <= 65) {
			System.out.println("Is the visitor currently enrolled as a student? Enter 'y' or 'n' " + "\n");
			char EnrolledasStudent = scan.next().charAt(0);
			if (EnrolledasStudent == 'y') {
				TicketPrice = 20 * 0.75;
				System.out.println("Ticket Price: " + TicketPrice);
			} else {
				TicketPrice = 20;
				System.out.println("Ticket Price: " + TicketPrice);
			}
		}
		else {
			TicketPrice = 20 * 0.5;
			System.out.println("Ticket Price: " + TicketPrice);
		}

	}

}