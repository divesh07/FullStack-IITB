package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for ( int i= 0 ; i < size ; i++){
            arr[i] = scan.nextInt();
        }
        insertionSort(arr);

    }

    public static void insertionSortDesc(int[] arr){
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] < arr[j]) {
                swap(j - 1, j, arr);
                j = j - 1;
            }
        }
        print(arr);
    }

    public static void print(int[] arr){
        for ( int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }
    public static void insertionSort(int[] arr) {
        int size = arr.length;
        for (int i = 1; i < 3; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(j - 1, j, arr);
                j = j - 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int i, int j, int[] arr) {
        // swap min with i
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
