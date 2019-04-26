package algorithms.Recurssion;

import java.util.Scanner;

public class Pattern {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        func(n);
    }

    // function to print the required pattern
    public static String func(int n) {
        //write your code here
        if (n <= 0){
            return "";
        }
        String str = "*" + func(n-1);
        System.out.println(str);
        return str;
    }

}
