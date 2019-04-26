import java.util.Scanner;

public class ArrayMax {
	public static void main(String[] args) {
		int num, max;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array:");
		num = scan.nextInt();
		int array[] = new int[num];
		System.out.println("Enter elements of array: ");
		for (int index = 0; index < num; index++) {
			array[index] = scan.nextInt();
		}
		max = array[0];
		for (int index = 0; index < num; index++) {
			if (max < array[index]) {
				max = array[index];
			}
		}
		System.out.println("Maximum value:" + max);
	}
}
