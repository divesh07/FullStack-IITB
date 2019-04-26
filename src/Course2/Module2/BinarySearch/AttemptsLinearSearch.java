package BinarySearch;

import java.util.Scanner;

//number of unsuccessful attempts made to search for an element in the array using linear search.
public class AttemptsLinearSearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] arr = new int[size];
        for ( int i = 0 ; i < size ; i ++){
            arr[i] = scan.nextInt();
        }
        int key = scan.nextInt();
        System.out.println(getLinearSearchUnsuccessfulComparisonCount(arr,key));
    }

    public static int getLinearSearchUnsuccessfulComparisonCount(int[] inputArr, int key) {
        int count = 0;
        for ( int i = 0 ; i < inputArr.length ; i++){
            if ( inputArr[i] == key){
                return count;
            }
            count++;
        }
        return count;
    }
}
