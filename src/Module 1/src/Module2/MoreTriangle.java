package Module2;

import java.util.Scanner;

public class MoreTriangle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();

        int count = 1;
        for ( int i = 1; i <=rows ; i++){
            for ( int j =1 ; j <=i ; j++ , count++){
                System.out.print(count);
            }
            System.out.println();
        }
    }
}
