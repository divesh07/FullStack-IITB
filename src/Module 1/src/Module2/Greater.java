package Module2;
import java.util.Scanner;

public class Greater {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);

        // Enter the three numbers in the input console separated by a space (or in different lines)
        double number1 = scan.nextDouble();
        double number2 = scan.nextDouble();
        double number3 = scan.nextDouble();
        double largest = 0.0;
        // Write the nested if-else statements here
        if ( number1 >= number2){
            if ( number1 >= number3){
                largest = number1;
            }else{
                largest = number3;
            }
        }else if ( number2 >= number3){
                largest = number2;
        }else{
            largest = number3;
        }
        scan.close();
        System.out.print(largest);
    }

}
