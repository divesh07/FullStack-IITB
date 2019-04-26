package algorithms.Recurssion;

import java.util.Scanner;

//calculate the sum of n consecutive natural numbers
public class Sum {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value = sum(n);
        System.out.print(value);
    }

    public static int sum(int n){
        //write the logic here
        if (n <= 1)
            return n;
        return n + sum(n-1);
    }

}
