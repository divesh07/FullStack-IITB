package Module2.Session3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadNumbers {
    public static void main(String[] args) throws FileNotFoundException {
        File input = new File("C:\\Users\\dgandhi\\Documents\\Upgrad Assignments\\Module2\\Session3\\quiz_numbers.txt");
        Scanner scan = new Scanner(input);
        int sum = 0;
        int lineNumber = 0;
        while(scan.hasNext()){
            lineNumber++;
            int number = scan.nextInt();
            sum += number;
        }
        double mean = (double)sum/lineNumber;
        System.out.println(mean);
    }
}
