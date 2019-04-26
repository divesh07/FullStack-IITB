package arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] random = {2,4,5,10,42,76};
        int arr[] = new int[5];
        arr[0] = 1;
        System.out.println(Arrays.toString(random));
        System.out.println(Arrays.toString(arr));

        int a[],b;
        int[]c ,d;
    }
}


class Print {

    public static void main(String[] args) {
        int random[ ] = {2, 4, 5, 10};
        printArray(random);
    }

    public static void printArray(int[] arr) {

        // Declare printArray method here
        for( int number : arr){
            System.out.println(number);
        }
    }
}
 class Source {
    public static void main(String args[]) {
        try {
            Scanner s = new Scanner(System.in);
            int n = s.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = s.nextInt();
            int k = s.nextInt();
            search(arr, k);
        }catch(Exception e) {
            System.out.println(false);
        }
    }

    // Method to search for k in an unsorted array
    static void search(int[] arr, int k) {
        // Write your code
        try {
            boolean flag = false;
            for (int number : arr) {
                if (number == k) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag);
        }catch (Exception e){
            System.out.println(false);
        }
    }
}