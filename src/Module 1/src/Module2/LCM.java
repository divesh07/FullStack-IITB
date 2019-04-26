package Module2;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        // find LCM of two numbers
        Scanner input = new Scanner(System.in);
        int number1 = input.nextInt();
        int number2 = input.nextInt();

        int multiple;
        // Take the highest number , check if its divisible by smaller number , if yes highest no is the LCM , else add
        // to the highest no and move on till we find the LCM
        multiple = number1>number2 ? number1 : number2;
        Boolean flag = true;
        while(flag){
            if(multiple%number1 ==0 && multiple%number2 == 0){
                System.out.println("LCM = " + multiple);
                flag = false;
            }
            multiple++;
        }

    }
}

