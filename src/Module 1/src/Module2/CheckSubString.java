package Module2;

import java.util.Scanner;

public class CheckSubString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Enter the first string
        String string1 = scan.nextLine();
        // Enter the second string
        // the code checks if the second string is
        // a substring of the first
        String string2 = scan.nextLine();
        boolean isSubstring = false;
        // change the value of isSubstring to true if
        // the second string is a substring of the first

        for( int i = 0 ; i < string1.length(); i ++) {
            for (int j = 0; j < string2.length(); j++)
                if (string2.charAt(j) == string1.charAt(i)) {
                    if ( string1.substring(i).length() >= string2.length() && string1.substring(i, i + string2.length()).equals(string2)) {
                        isSubstring = true;
                        System.out.println("The second string is a substring of the first.");
                        break;
                    }
                }
                if (isSubstring)
                    break;
        }

        if (!isSubstring) {
            System.out.println("The second string is NOT a substring of the first.");
        }
        scan.close();
    }
}
