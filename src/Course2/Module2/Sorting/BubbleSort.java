package Sorting;

import java.util.Arrays;

public class BubbleSort {
    static int swapElementCount = 0;
    public static void main(String[] args) {

        int[] array = {12, 8, 9, 10, 15, 4, 3, 6, 7};

        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    public static int[] sort( int[] array){
        int n = array.length;

        for ( int i = 0 ; i< n ; i++){
            for ( int j =1 ; j < n -i ; j++) {
                if (array[j - 1] > array[j]) {
                    swap(j - 1, j, array);
                }
            }
            if ( swapElementCount == 0){
                break;
            }
        }
        return array;
    }

    public static void swap ( int i , int j , int[] arr){
        int temp =  arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        swapElementCount = 1;
    }
}
