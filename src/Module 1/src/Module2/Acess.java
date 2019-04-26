package Module2;

import java.util.Scanner;
import java.lang.String;

public class Acess {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();
        if ( age > 18){
            System.out.println("Access Granted");
        }else{
            System.out.println("Access Denied");
        }


    }
}
