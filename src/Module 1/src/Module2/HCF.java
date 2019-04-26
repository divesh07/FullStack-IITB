package Module2;
import java.util.Scanner;

public class HCF {
    public static void main(String[] args) {
        //calculate the HCF or the greatest common divisor of two numbers.
        //HCF is the highest number that divides two numbers
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        int hcf;
        hcf = num1<num2 ? num1 : num2;
        Boolean flag = true;
        while(flag){
            if(num1 % hcf ==0 && num2 % hcf ==0){
                System.out.println(hcf);
                flag = false;
            }
            hcf--;
        }
        scan.close();

    }
}
