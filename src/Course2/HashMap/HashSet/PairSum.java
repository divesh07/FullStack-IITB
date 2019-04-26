package HashSet;

import com.sun.javafx.image.IntPixelGetter;

import java.util.HashSet;
import java.util.Scanner;

public class PairSum {
    //You will be given an array of integers and a target sum.
    // You have to check whether there exist any two integers in the array
    // whose sum is equal to the given target sum.
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // number of the elements
        int n = in.nextInt();
        int array[] = new int[n];
        //storing the input integers to an array
        for(int i =0;i<n;i++){
            array[i] = in.nextInt();
        }
        // getting the target sum from input
        int targetSum = in.nextInt();
        //write your code here
        if ( n < 2){
            System.out.println(false);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        boolean found = false;

        for (int arr : array){
            int findElementInSet = targetSum-arr;
            if (set.contains(findElementInSet)){
                System.out.println(true);
                found = true;
                break;
            }else{
                set.add(arr);
            }
        }
        if (!found) {
            System.out.println(false);
        }
    }


}
