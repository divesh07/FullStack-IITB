package revision;

import java.util.Arrays;

public class Sorting {

    public static int[] bubbleSort(int[] arr){
     for ( int i = 0 ; i < arr.length; i++){
         for ( int j =1 ; j < arr.length - i ; j++){
             if ( arr[j-1] > arr[j])
                 swap(j-1,j,arr);
         }
     }
     return arr;
    }

    public static int[] selectionSort(int[] arr){
        for ( int i =0 ; i < arr.length-1 ; i++){
            int min = i;
            for ( int j = i+1; j< arr.length; j++ ){
                if ( arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(i, min, arr);
        }
        return arr;
    }

    public static int[] insertionSort(int[] arr){
        for ( int i =1 ; i < arr.length ; i++){
            int j = i;
            while ( j > 0 && arr[j-1] > arr[j]){
                swap(j-1, j, arr);
                j--;
            }
        }
        return arr;
    }

    public static int[] insertionSortDesc(int[] arr){
        for ( int i = 1 ; i< arr.length; i++){
            int j =i;
            while ( j > 0 && arr[j-1] < arr[j]){
                swap(j-1, j, arr);
                j--;
            }
        }
        return arr;
    }

    // Helper function to merge 2 arrays into 1 single array
    public static int[] merge(int[] arr, int start , int mid, int end){
        int left = start;
        int right = mid + 1;
        int k = 0;

        int[] mergedArr = new int[arr.length];
        while ( left <= mid && right <= end){
            if ( arr[left] <= arr[right]){
                mergedArr[k] = arr[left];
                k++; left++;
            }else{
                mergedArr[k] = arr[right];
                k++; right++;
            }
        }

        while ( left <= mid){
            mergedArr[k] = arr[left];
            k++; left++;
        }

        while (right <= end){
            mergedArr[k] = arr[right];
            k++; right++;
        }

        left = start;
        k = 0;
        while ( left <= end){
            arr[left] = mergedArr[k];
            left++;
            k++;
        }

        return arr;
    }

    // Divides array into 2 sub arrays from the mid
    public static int[] mergeSort(int[] arr, int start , int end){
        if ( start < end){
            int mid = ( start + end ) /2 ;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
        return arr;
    }

    // helper function which takes end as partition
    // sorts the array based on partition
    // returns partition
    public static int partition(int[] arr, int start , int end){
        int pivot = arr[end];
        int i = start;
        for ( int j = start ; j < end ; j++){
            if (arr[j] <= pivot){
                swap(i, j, arr);
                i++;
            }
        }
        swap(i,end,arr);
        return i;
    }

    public static int[] quickSort(int[] arr, int start, int end){
        if ( start < end){
            int p = partition ( arr, start, end);
            quickSort(arr, start, p-1);
            quickSort(arr, p+1, end);
        }
        return arr;
    }

    public static void swap( int i , int j , int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j]  = temp;

    }

    public static void main(String[] args) {
        int[] randomNumbers = {13, 3242, 23, 2351, 352, 3915, 123, 32, 1, 5, 0};
        int[] sortedNumbers;

        sortedNumbers = bubbleSort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        sortedNumbers = selectionSort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        sortedNumbers = insertionSort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        sortedNumbers = insertionSortDesc(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));

        sortedNumbers = mergeSort(randomNumbers,0, randomNumbers.length -1 );
        System.out.println(Arrays.toString(sortedNumbers));

        sortedNumbers = quickSort(randomNumbers,0, randomNumbers.length -1 );
        System.out.println(Arrays.toString(sortedNumbers));

    }
}
