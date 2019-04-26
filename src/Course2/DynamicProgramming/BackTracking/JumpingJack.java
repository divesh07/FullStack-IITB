package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class JumpingJack {
    //Write a code that gives an output of the minimum number of jumps needed to reach the destination provided.
    //F(n) = 1 + min ( f (n-1) , f(n/2) , f(n/3)
    //F(1) = 0 - base case
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int distance = scan.nextInt();
        System.out.println(minJump(distance));
    }

    public static int minJump(int n)
    {
        int f[] = new int[n+1];
        /* Declare an array to store the minimum jumps. */
        /* Initialise the base condition */
        /* Fill in the array to find Minimum Jumps from a certain distance */
        f[0]=0;
        f[1]=0;
        for ( int i = 2 ; i<=n ; i++){
            if (i%2 == 0 && i%3 ==0) {
                f[i] = 1 + Math.min(f[i - 1], Math.min(f[i/2], f[i/3]));
            }else if (i%2 == 0 && i%3 !=0){
                f[i] = 1 + Math.min(f[i - 1], f[i/2]);
            }else if (i%2 != 0 && i%3 ==0) {
                f[i] = 1 + Math.min(f[i - 1], f[i/3]);
            }else{
                f[i] = 1 + f[i-1];
            }
        }
        System.out.println(Arrays.toString(f));
        return f[n];
    }
}
