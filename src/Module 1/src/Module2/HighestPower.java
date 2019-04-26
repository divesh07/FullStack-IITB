package Module2;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class HighestPower {
    public static void main(String[] args) {
        // code that prints the highest power of 2, less than or equal to a given number
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int result = 1;
        if ( number >= 2) {
            boolean flag = true;
            while ( flag) {
                // Power of 2 numbers have one bit set
                // When 1 is subtracted set bit becomes unset and unset becomes set
                // so subtrcting number and number -1 would be zero
                if ((number & (number - 1)) == 0){
                    System.out.println(number);
                    flag = false;
                }
                number--;
            }
        }else{
            System.out.println("Please enter an integer >= 2");
        }
        scan.close();
    }
}
