package algorithms;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class FindDuplicates {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the no of students in the database");

        int n = scan.nextInt();
        int id[] = getInput(n);
        findDuplicate(id);
        findDuplicateUsingSet(id);
        findDuplicatesUsingCount(id);
    }

    public static int[] getInput(int n){
        int input[] = new int[n];
        for ( int i = 0 ; i< n ; i++){
            input[i] = randomNumber(1,2*n);
        }
        return input;
    }

    public static int randomNumber(int min,int max){
        return ThreadLocalRandom.current().nextInt(min,max);
    }
    public static void findDuplicate(int[] arr){
        System.out.println(Arrays.toString(arr));
        for(int i = 0 ; i< arr.length ; i++){
            for ( int j = i+1 ; j < arr.length; j++){
                if (arr[i] == arr[j]){
                    System.out.println("Duplicate element found "  + arr[i]);
                    break;
                }
            }
        }
    }

    public static void findDuplicateUsingSet(int[] arr){
        System.out.println(Arrays.toString(arr));
        Set<Integer> dup = new HashSet<Integer>();
        for(int i = 0 ; i< arr.length ; i++){
            if (!dup.add(arr[i])){
                System.out.println("Duplicate element" + arr[i]);
            }
        }
    }

    public static void findDuplicatesUsingCount(int[] id) {
        id = new int[] {5,1,3,5,6,2,4};
        System.out.println("Duplicate data : ");
        int count[] = new int[10];
        for (int i = 0; i < id.length; i++) {
            count[id[i]]++; // Increments count value from 1 to 0 at the location id[i];
            System.out.println(Arrays.toString(count));
            if (count[id[i]] == 2)
                System.out.print(id[i] + " ");
        }
        System.out.println();
    }
}

