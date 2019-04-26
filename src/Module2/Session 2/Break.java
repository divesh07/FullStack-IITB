public class Break {
	public static void main(String args[]) {
		for (int number = 1; number <= 100; number++) {
			if (number == 67) {
				System.out.println("Found number 67.");
				break;
			} else {
				System.out.println(number);
			}
		}
		// System.out.println("This is the statement after the loop");
	}
}
