package Module2.Session3;

import java.util.Scanner;

public class LCM {

    public static int lcm(int num1, int num2){
        boolean flag = true;
        int lcm = num1 > num2 ? num1 : num2;
        while(flag){
            if ((lcm % num1 == 0) && (lcm % num2 ==0) ){
                flag = false;
                break;
            }
            lcm++;
        }
        return lcm;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Enter the two numbers in the input console
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();
        System.out.print(lcm(number1, number2));
    }
}
