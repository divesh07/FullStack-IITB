package session1.Inheritance.test;

import java.io.Console;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Console my_console = System.console();
        String my_val = my_console.readLine();
        int i = Integer.valueOf(my_val);
        System.out.println(i);
    }
/*    public String ReadLine(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
    */


}


