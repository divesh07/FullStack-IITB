package algorithms.Assignments;

import java.util.Scanner;

// calculate the sum of the digits of a given number, using recursion
public class SumOfDigits {

    public static int sum(int n) {
        //write the logic here
        if (n <= 0)
            return 0;
        return (n% 10 + sum(n/10));

    }

    public static int evenSum(int n) {
        if(n <= 1)
            return 0;

        else if (n % 2 == 0)
            return (n + evenSum(n - 1));
        else
            return evenSum(n - 1);
    }

    private static int evenSum2(int n){
        return (n/2)*(1 + n/2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(sum(num));
    }
}
