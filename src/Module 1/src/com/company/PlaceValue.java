package com.company;
import java.util.Scanner;

public class PlaceValue {
    public static void main(String[] args) {

        //Create new scanner
        Scanner input = new Scanner(System.in);

        //Values of each digit
        int tenThousands, thousands, hundreds, tens, ones;

        //Prompt user to input 5 digit number
        int number = input.nextInt();
        if (number > 99999) {
            System.out.println("\nError! Number more than 5 digits.");
        }
        else if (number < 10000) {
            System.out.println("Error! Number less than 5 digits.");
        }
        else if (10000<=number&&number<=99999){
            //WRITE YOUR CODE HERE

            tenThousands = ( number/10000);
            System.out.println(tenThousands);

            thousands  = (number/1000)%10;
            System.out.println(thousands);

            hundreds = (number/100)%10;
            System.out.println(hundreds);

            tens = (number/10)%10;
            System.out.println(tens);

            ones = number %10;
            System.out.println(ones);









        }
    }
}
