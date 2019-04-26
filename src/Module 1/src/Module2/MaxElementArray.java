package Module2;

import java.util.Scanner;

public class MaxElementArray {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of elements");
        int arraySize = scan.nextInt();
        int[] arr = new int [arraySize];
        int max =0;
        System.out.println("Enter the number");
        for (int i =0 ; i<arraySize ; i++){
            arr[i] = scan.nextInt();
            if (arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
