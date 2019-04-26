package Sorting;

import java.util.Scanner;

public class BubbleSortSwapCount {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Number of outer iterations to perform
        int M = scan.nextInt();
        int size = scan.nextInt();
        int[] arr = new int[size];
        for ( int i = 0 ; i < size; i++){
            arr[i] = scan.nextInt();
        }
        int swapCount = totalBubbleSortSwaps(M, arr);
        System.out.println(swapCount);

    }

    public static int totalBubbleSortSwaps( int M, int[] arr){
        int n = arr.length;
        int swapCount = 0;
        for ( int i = 0 ; i < M ; i++){
            for ( int j = 1 ; j < n-i ; j++){
                if ( arr[j-1] < arr[j]) {
                    swap(j - 1, j, arr);
                    swapCount++;
                }
            }
        }
        return swapCount;
    }

    public static void swap(int i , int j , int[] arr){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
