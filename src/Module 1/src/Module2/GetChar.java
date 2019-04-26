package Module2;
import java.util.Scanner;

public class GetChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Character ch = scan.next().charAt(4);

        System.out.print(ch);
    }
}
