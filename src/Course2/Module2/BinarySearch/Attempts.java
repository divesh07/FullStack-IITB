package BinarySearch;

import java.util.Scanner;

// returns the number of unsuccessful attempts made to search for an element in the array
public class Attempts {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            //System.out.println("Enter no of elements");
            int size = scan.nextInt();
            int[] arr = new int[size];

            for ( int i = 0 ; i < size ; i ++){
                arr[i] = scan.nextInt();
            }
            //System.out.println("Enter key to search");
            int key = scan.nextInt();

            System.out.println(getBinarySearchUnsuccessfulComparisonCount(arr,key));

        }

        public static int getBinarySearchUnsuccessfulComparisonCount(int[] inputArr, int key) {
            int start = 0 ;
            int end = inputArr.length -1;
            int count = 0 ;
            while (start <=end ){
                int mid = start + ((end - start)/2);
                //System.out.println("Mid element " + inputArr[mid]);
                if ( key == inputArr[mid]){
                    //System.out.println("Element found");
                    return count;
                }else if ( key > inputArr[mid]){
                    count++;
                    start = mid + 1;
                    //System.out.println("Element greater than middle");
                }else {
                    count++;
                    end = mid - 1;
                    //System.out.println("Element less than middle");
                }
            }
            return count;
        }
}
