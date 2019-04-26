import java.util.Scanner;

public class TwoDArrayMax {
	public static void main(String[] args) {
		int rowsize, columnsize;
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of rows in the array: ");
		rowsize = scan.nextInt();
		System.out.print("Enter number of columns in the array: ");
		columnsize = scan.nextInt();

		int array[][] = new int[rowsize][columnsize];
		System.out.println("Enter elements of array: ");
		for (int rowindex = 0; rowindex < rowsize; rowindex++) // loop through rows
		{

			for (int colindex = 0; colindex < columnsize; colindex++) // fill all the columns within a row
																					{
				System.out.println("Enter array element " + "array[" + rowindex + "][" + colindex + "]");
				array[rowindex][colindex] = scan.nextInt();
			}

		}

		int max = array[0][0];

		for (int rowindex = 0; rowindex < rowsize; rowindex++) {
			for (int colindex = 0; colindex < columnsize; colindex++) {

				if (max < array[rowindex][colindex]) {
					max = array[rowindex][colindex];
				}
			}
		}
		System.out.println("Maximum value:" + max);
	}
}
