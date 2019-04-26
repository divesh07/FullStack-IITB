package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr){
        int size = arr.length;
        for ( int i = 0 ; i < size -1 ; i++){
            int min = i;
            for ( int j = i+1 ; j < size ; j++){
                if ( arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(i , min , arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap( int i , int j , int[] arr){
        // swap min with i
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

