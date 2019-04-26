package algorithms;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number");
        int number  = scan.nextInt();
        //printFibSeries(number);
        System.out.println(fib4(number));

    }
    public static void printFibSeries(int x){
        int sum = 0;
        int x1 = 0;
        int x2 = 1;
        for ( int i = 0 ; i< x ; i++){
            System.out.println(x1);
            sum = ( x1 + x2 );
            x1 = x2;
            x2 = sum;
        }
    }


    // Algo 1 per lectures
    // T(n) ∈ O(2^n) Exponential time - time complexity
    // S(n) ∈ 0(n) Linear space - Space complexity
    public static int fib2(int x){
        if ( x < 2){
            return x;
        }else{
            return fib2(x-1) + fib2(x -2);
        }
    }

    // Algo 2 per lectures
    // T(n) ∈ 0(n) Linear time
    // S(n) ∈ 0(n) Linear space - Space complexity
    public void fib3(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        for(int i=2;i<=n;i++)
            f[i]=(f[i-1]+f[i-2])%10;
        System.out.println("Fibonacci number : "+f[n]);
    }

    // Algo 3 per lectures Linear time O(n) and constant space algorithm O(1)
    // T(n) ∈ 0(n) Linear time
    // S(n) ∈ 0(1) Constant space
    public static int fib4(int n) {
        int a = 0, b = 1, c = n;
        for (int i=2; i<=n; i++){
            c = (a + b)%10;
            a = b;
            b = c;
            if ( i==5){
                System.out.println(a + "" + b + "" + c);
            }
        }
        return c;
    }
}
