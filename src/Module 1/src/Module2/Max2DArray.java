package Module2;

import java.util.Scanner;

public class Max2DArray {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        System.out.println("Enter no of rows");
        int rowSize = scan.nextInt();
        System.out.println("Enter no of columns");
        int columnSize = scan.nextInt();
        int[][] matrix = new int[rowSize][columnSize];

        for ( int i = 0 ; i < rowSize ; i++){
            for ( int j = 0 ; j < columnSize; j++){
                System.out.println("Enter value for matrix[" + i + "][" + j + "]");
                matrix[i][j] = scan.nextInt();
            }
        }
        // print max
        int max = matrix[0][0];
        for ( int i = 0 ; i < rowSize ; i++){
            for ( int j = 0 ; j < columnSize; j++){
                if ( max < matrix[i][j]) {
                    max = matrix[i][j];
                }
            }
        }
        System.out.println(max);
    }
}
