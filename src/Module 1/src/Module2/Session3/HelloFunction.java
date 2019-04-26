package Module2.Session3;

import java.util.Scanner;

public class HelloFunction {

    public static void main(String[] args) {

        System.out.println("Whom would you like to say hello to?  ");
        Scanner scan = new Scanner(System.in);
        String name;
        name = scan.next();
        printGreeting(name);
    }

    public static void printGreeting(String name) {
        System.out.println("Hello " + name);
    }
}
