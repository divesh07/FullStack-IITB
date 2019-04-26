package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSortString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        String firstNames[] = new String[size];
        String lastNames[] = new String[size];
        for (int i = 0; i < size; i++) {
            firstNames[i] = scanner.next().toLowerCase();
        }
        for (int i = 0; i < size; i++) {
            lastNames[i] = scanner.next().toLowerCase();
        }
        insertionSort(firstNames);
        insertionSortDesc(lastNames);

    }

    public static void insertionSortDesc(String[] arr){
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(arr[j]) < 0) {
                swap(j - 1, j, arr);
                j = j - 1;
            }
        }
        print(arr);
    }

    public static void insertionSort(String[] arr) {
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            int j = i;
            while (j > 0 && arr[j - 1].compareTo(arr[j]) > 0) {
                swap(j - 1, j, arr);
                j = j - 1;
            }
        }
        print(arr);
    }


    public static void print(String[] arr){
        for ( int i = 0 ; i < arr.length ; i++){
            System.out.println(arr[i]);
        }
    }

    public static void swap(int i, int j, String[] arr) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
