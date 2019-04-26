package example;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] randomNumbers) {
        return mergeSort(randomNumbers, 0, randomNumbers.length - 1);
    }

    public static int[] mergeSort(int[] numbers, int first, int last) {
        // first denotes the starting index of the "numbers" array
        // last denotes the ending index of the "numbers" array

        //Complete this function
        if ( first < last){
            int mid = ( first + last ) /2;
            mergeSort(numbers, first, mid);
            mergeSort(numbers, mid + 1 , last);
            merge(numbers,first,mid ,last);
        }
        return numbers;

    }

    /// .......
    // Write the Merge function here which uses the merge sort to sort the array in decreasing order...
    /// .......
    public static int[] merge(int[] numbers, int first , int mid , int last ){
        System.out.println( numbers[first] + " " + numbers[mid] + " " + numbers[last]);
        int left = first;
        int right = mid + 1;
        int k = 0 ; // index of merged sub array
        int[] merged = new int[numbers.length]; // merged sub array

        while ( left <=mid && right <= last){
            if ( numbers[left] >= numbers[right]){
                merged[k] = numbers[left];
                left++;k++;
            }else{
                merged[k] = numbers [right];
                right++;k++;
            }
        }
        while(left<=mid){
            merged[k] = numbers[left];
            left++;k++;
        }
        while(right<=last){
            merged[k] = numbers[right];
            right++;k++;
        }
        left = first;
        k = 0;
        while( left<= last){
            numbers[left] = merged[k];
            left++;
            k++;
        }
        //System.out.println("Sorted  " + Arrays.toString(numbers));
        return numbers;
    }

    public static void main(String args[]) {

        int[] randomNumbers = {9,45,76,23,47,1,5,11};
        int[] sortedNumbers;
        sortedNumbers = sort(randomNumbers);
        System.out.println(Arrays.toString(sortedNumbers));
    }
}

