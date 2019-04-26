import java.util.Scanner;

public class Grades1 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the score \n");
		int testscore = scan.nextInt();

		char grade;

		if (testscore >= 90) {
			grade = 'A';
		} else if (testscore >= 80) {
			grade = 'B';
		} else if (testscore >= 65) {
			grade = 'C';
		} else if (testscore >= 50) {
			grade = 'D';
		} else if (testscore >= 35) {
			grade = 'E';
		} else {
			grade = 'F';
		}
		System.out.println("Grade = " + grade);
	}
}