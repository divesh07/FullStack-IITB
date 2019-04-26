package revision;

import java.io.File;
import java.util.Scanner;


public class Recursion {
    // Calculate the sum of n consecutive natural numbers
    public static int sum(int n){
        //write the logic here
        if ( n <= 1)
            return n;
        return n + sum(n-1);
    }

    //  calculate the power of the base value
    public static int power(int base, int power){
        //write the logic here
        if ( power <= 0)
            return 1;
        return base  * power(base, power-1);
    }

    //  calculate factorial
    public static int factorial(int n){
        if ( n == 0)
            return 1;
        return n * factorial(n -1);
    }

    // find file
    public static void findFile(String fileName, String path){
        File directory = new File(path);
        if ( directory.isDirectory()){
            File[] list = directory.listFiles();
            for ( File file : list){
                if ( file.isDirectory()){
                    findFile(fileName, file.getAbsolutePath());
                }else{
                    if (file.getName().equalsIgnoreCase(fileName)){
                        System.out.println("File found");
                    }
                }
            }
        }
    }

    // find sum of digits exe 452 = 4 + 5 + 2 = 11
    public static int sumOfDigits(int n){
        if ( n <= 0 )
            return n;
        return n%10 + sumOfDigits( n/10);
    }

    // check if 5 digit number is palandrome
    public static boolean isPalindrome(int[] n , int index){
        if ( index > n.length/2) {
            return true;
        }
        // check first and last element
        if ( n[index] == n[n.length-1-index]){
            return isPalindrome(n, index+1);
        }else {
            return false;
        }



    }

    // prints a pattern
    public static String printPattern(int pattern){
        if (pattern <= 0)
            return "";
        String str = "*" + printPattern(pattern -1 );
        System.out.println(str);
        return str;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //System.out.print(sum(sc.nextInt()));
        //System.out.print(power(sc.nextInt(),sc.nextInt()));
        printPattern(5);
        System.out.println(factorial(5));
        String projectPath = System.getProperty("user.dir");
        findFile("src.iml", projectPath);
        System.out.println(sumOfDigits(492));

        int num[] = new int[5];
        for(int i=0; i< 5;i++)
            num[i]=sc.nextInt();
        boolean answer = isPalindrome(num, 0);
        System.out.println(answer);
    }
}






