import java.util.Scanner;

public class JavaTriangle {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of rows you want to see in triangle  ");
        int totalrows = scan.nextInt();
        
        for (int rownumber = 1; rownumber <= totalrows; rownumber++) { // loop through each row in triangle
            for (int number = 1; number <= rownumber; number++) { // loop within each row
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }
}
