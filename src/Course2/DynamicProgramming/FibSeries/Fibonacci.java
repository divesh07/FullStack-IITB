package FibSeries;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        //sum of last three numbers
        Scanner scan = new Scanner(System.in);
        // Enter the number n
        int n = scan.nextInt();
        System.out.println(fib(n));
        scan.close();
    }

    static int fib(int n) {
        /* Declare an array to store Fibonacci numbers */
        /* Assign the 0th, 1st, and 2nd numbers of the Fibonacci series to 0, 1, and 2 respectively */
        /* Add the previous three numbers in the series, and store them */
        /* Return the nth element in the series */
        if ( n<=2){
            return n;
        }
        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for ( int i = 3 ; i< n; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
        }
        System.out.println(Arrays.toString(arr));
        return arr[n-1];
    }
}
