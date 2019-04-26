package Module2;
import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        // Input weight (in kgs) in the input console
        double weight = scan.nextDouble();

        // Input height (in metres) in the input console
        double height = scan.nextDouble();
        double bmi = weight / (height * height);
        String result; // should contain the message

        // Write the code If.. Else
        if (bmi < 18.5){
            result = "Underweight";
        }else if( bmi >=18.5 && bmi <= 24.9){
            result = "Normal";
        }else if(bmi >=25 && bmi <= 29.9){
            result = "Overweight";
        }else if (bmi >=30 && bmi <= 34.9){
            result = "Obese";
        }else if (bmi >=35 && bmi < 39.9){
            result = "Severely obese";
        }else{
            result = "Morbidly obese";
        }
        System.out.println(result);
        scan.close();
    }
}
