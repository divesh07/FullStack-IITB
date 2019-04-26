import java.util.Scanner;    


public class Choices {
    public static void main(String[] args) {
        char choice;
        Scanner scan = new Scanner(System.in);

        // Ask the user to enter y or n.
        System.out.print(" Are you over 18. Enter Y or N: ");
        choice = scan.next().charAt(0);
        // the first character, y or n,  you input here is picked up by the variable choice. 

        switch (choice) {
            case 'y':
                System.out.println("You may access this website.");
                break;
            case 'Y':
                System.out.println("You may access this website.");
                break;
            // break: The break statement tells the code to quit once a case is TRUE 
            // and has been executed. If there is no break, execution flows through into the next case
            case 'N': 
                System.out.println("You don't have access to this material");
                break;
            case 'n':
                System.out.println("You don't have access to this material");
                break;
            default: // executed if none of the above cases is met
                System.out.println("Incorrect Input!");                
        }
    }
}
