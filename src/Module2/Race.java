import java.util.Scanner;

public class Race {
	public static void main(String args[]) {
		float time1, time2;
		System.out.println("Enter the time taken by runner 1 " + "/n");
		Scanner in = new Scanner(System.in);
		time1 = in.nextFloat();

		System.out.println("Enter the time taken by runner 2 " + "/n");
		time2 = in.nextFloat();
		
		if (time1 < time2) {
			System.out.println(" Runner 1 won the race ");
			
		} else if (time2 < time1) {
			System.out.println("Runner 2 won the race");

		} else {
			System.out.println("Race was a draw.");

		}
	}
}
