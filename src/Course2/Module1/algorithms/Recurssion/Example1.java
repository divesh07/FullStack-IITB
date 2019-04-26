package algorithms.Recurssion;

import java.util.Scanner;

public class Example1 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a positive no: ");
        int n = sc.nextInt();
        int value = Function.func(n);
        System.out.println("Output is : "+value);
    }
}

class Function {
    public static int func(int n) {
        if (n == 1)
            return n;
        else
            return func(n - 1);
    }
}
