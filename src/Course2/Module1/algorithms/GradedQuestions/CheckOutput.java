package algorithms.GradedQuestions;

import java.util.Arrays;

public class CheckOutput {
    public static void main(String[] args) {
        //System.out.println(func(3,3));
        //System.out.println(func(12));
        factorial1(500000000);
    }

    public static int func(int x, int n) {
        if (n == 0)
            return 1;
        else if(n%2 == 0)
            return func(x*x, n/2);
        else
            return x*func(x*x, n/2);
    }

    public static int func(int n) {
        if (n == 1)
            return 0;
        else
            return 1 + func(n/2);
    }

    public static void factorial2(int n) {
        int[] factorials = new int[n + 1];
        Arrays.fill(factorials, 1);
        System.out.println(Arrays.toString(factorials));
        for (int i = 0; i <= n - 1; i++) {
            factorials[i + 1] = (i + 1) * factorials[i];
            System.out.println(Arrays.toString(factorials));
        }
        System.out.println(factorials[n]);
    }

    public static void factorial1(int n) {

        int factorial = 1;
        int index = 1;
        for (int i = 0; i <= Math.pow(n, n); i++) {
            if (i == factorial * index) {
                factorial = i;
                index += 1;
                if (index == n + 1) {
                    System.out.println(factorial);
                    break;
                }
            }
        }
    }
}
