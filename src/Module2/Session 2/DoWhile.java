public class DoWhile {
	public static void main(String args[]) {
		int number = 1;
		do {
			System.out.println(number);
			number = number++;
		} while (number <= 100);
	}
}
