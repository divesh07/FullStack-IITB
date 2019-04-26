package Module2.Session3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args)  throws FileNotFoundException {
        File input = new File("C:\\Users\\dgandhi\\Documents\\Upgrad Assignments\\Module2\\Session3\\aliceinwonderland.txt");
        Scanner scan = new Scanner(input);
        while(scan.hasNextLine()) {
            System.out.println(scan.nextLine());
        }
    }
}
