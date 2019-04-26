package Module2;

import java.util.Scanner;

public class Diagnose {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        // User enters symptom: cough or sorethroat
        // Note - Enter 'sorethroat' as a single word
        String symptoms = scan.next();
        // User enters body temperature in Fahrenheit;
        double bodyTemperature = scan.nextDouble();

        //  write the code here
        if ( bodyTemperature >98.6 ){
            if (symptoms.equalsIgnoreCase("cough") ||symptoms.equalsIgnoreCase("sorethroat") ) {
                System.out.println("You have a fever");
            }else{
                System.out.println("Symptoms unrecognised. Visit a doctor!");
            }
        }else if (bodyTemperature <=98.6){
            if (symptoms.equalsIgnoreCase("cough") ||symptoms.equalsIgnoreCase("sorethroat") ) {
                System.out.println("You have a cold");
            }else{
                System.out.println("Symptoms unrecognised. Visit a doctor!");
            }
        }else{
            System.out.println("Symptoms unrecognised. Visit a doctor!");
        }
    }

}

