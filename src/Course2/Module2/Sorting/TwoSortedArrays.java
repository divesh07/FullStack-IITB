package Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSortedArrays {
    public static void main(String ss[]) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int sizeArray2 = scanner.nextInt();
        int sortedArray1[] = getArrayInput(sizeArray1, scanner);
        int sortedArray2[] = getArrayInput(sizeArray2, scanner);

        int descendingMerge[]=mergeBothInDescendingOrder(sortedArray1, sortedArray2);
        printArray(descendingMerge);
    }

    public static int[] getArrayInput(int size, Scanner scan){
        int[] arr = new int[size];
        for ( int i =0; i< size; i++){
            arr[i] = scan.nextInt();
        }
        return arr;
    }

    public static int[] mergeBothInDescendingOrder(int[] arr1, int[] arr2){
        int left = arr1.length-1;
        int right = arr2.length-1;
        int k = 0 ; // index of merged sub array
        int[] merged = new int[arr1.length + arr2.length ]; // merged sub array

        while ( left >= 0 && right >= 0){
            if ( arr1[left] >= arr2[right]){
                merged[k] = arr1[left];
                left--;k++;
            }else{
                merged[k] = arr2[right];
                right--;k++;
            }
        }
        while(left>=0){
            merged[k] = arr1[left];
            left--;k++;
        }
        while(right>=0 ){
            merged[k] = arr2[right];
            right--;k++;
        }
        return merged;
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println(arr[i]);

    }
}
