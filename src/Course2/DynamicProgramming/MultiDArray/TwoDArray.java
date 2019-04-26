package MultiDArray;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int[][] arr =  new int[2][3];
        for ( int i = 0 ; i < arr.length;i++){
            for( int j = 0 ; j< arr[i].length; j++){
                arr[i][j] = j;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }

        int[][] arr2={{0,1,2},{1,2,3}};

        for ( int i = 0 ; i < arr2.length;i++){
            for( int j = 0 ; j< arr2[i].length; j++){
                System.out.print(arr2[i][j] + " ");
            }
            System.out.println(" ");
        }


    }
}
