package List.assignment;

import java.util.Arrays;
import java.util.Scanner;

public class ZeroToEnd {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        moveZerosToEnd(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    // Method to find move all zeros to the end of the array
    static void moveZerosToEnd(int[] arr) {
        // Write your code here
        for ( int i =0 ; i < arr.length; i++){
            if(arr[i] == 0){
                // Replace with next non zero element
                for ( int j = i + 1  ; j < arr.length ;  j++){
                    if ( arr[j] != 0){
                        int tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                        break;
                    }
                }
            }
        }
    }

}
