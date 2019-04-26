package Module2;

import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        String result;
        Scanner scan = new Scanner(System.in);
        int score = scan.nextInt();
        if ( score >=35){
            result = "Pass";
        }else{
            result = "Fail";
        }
        System.out.println(result);

        int num1 = 9;
        int num2 = 9;
        if (num1 >= num2) {
            System.out.println("num1");
        } else {
            System.out.println(num2);
        }
    }
}
