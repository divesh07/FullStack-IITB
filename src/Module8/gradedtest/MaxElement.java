package gradedtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaxElement {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = s.nextInt();
        thirdMaxInteger(arr);
    }

    // Method to find the third maximum integer in the array
    static void thirdMaxInteger(int[] arr) {
        // Write your code here

        arr = Arrays.stream(arr).sorted().distinct().toArray();
        if ( arr.length <= 2){
            System.out.println("The array doesn't have a third maximum element");
        }else{
            System.out.println(arr[arr.length-3]);
        }

    }

}
