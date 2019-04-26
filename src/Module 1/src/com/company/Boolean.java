package com.company;

import java.util.Scanner;

public class Boolean {
    public static void main(String[] args) {
        int myAge;
        int ageOfBrother;

        //System.out.println("Enter your age");
        Scanner input = new Scanner(System.in);
        myAge = input.nextInt();

        //System.out.println("Enter your brother's age");
        ageOfBrother = input.nextInt();

        boolean discount = (myAge < 25 && ageOfBrother < 25 && myAge > 0 && ageOfBrother > 0);
        System.out.println(discount);

    }

}
