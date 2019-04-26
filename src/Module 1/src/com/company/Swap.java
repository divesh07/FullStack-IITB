package com.company;
import java.util.Scanner;

public class Swap {
    public static void main(String[] args) {
        //Create new scanner
        Scanner input = new Scanner(System.in);

        //Prompt user to number 1
        double number1 = input.nextDouble();

        //Prompt user to number 2
        double number2 = input.nextDouble();

        //WRITE YOUR CODE HERE
        double number3 = number2;
        number2 = number1;
        number1 = number3;

        System.out.println(number1);
        System.out.println(number2);

    }
}
