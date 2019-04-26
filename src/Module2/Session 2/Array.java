import java.util.Scanner;

public class Array {
	public static void main(String[] args) {
		
		int arraysize;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements in the array:");
		arraysize = scan.nextInt();
		int array[] = new int[arraysize];
		System.out.println("Enter elements of array: ");
		for (int index = 0; index < arraysize; index++) {
			array[index] = scan.nextInt();  // read array elements
		}

		System.out.println("The  elements of array are: ");
		for (int index = 0; index < arraysize; index++) {
			System.out.print(array[index] + "  "); // print array elements
		}
	}
}
