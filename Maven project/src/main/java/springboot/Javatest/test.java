package springboot.Javatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class test {


    public static void main(String[] args) throws FileNotFoundException {
        // Read user input
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(str);

        // Append
        StringBuilder sbr = new StringBuilder("geeks");
        sbr.append("forGeeks");
        System.out.println(sbr);

        // Reverse a string
        String input = "Reverse";
        byte[] byteArr = input.getBytes();
        byte[] newArr = new byte[byteArr.length];

        for (int i = 0 ; i < byteArr.length ; i++){
            newArr[i] = byteArr[byteArr.length-i-1];
        }

        System.out.println(new String(newArr));

        // Read a file
        File file = new File("C:\\Temp\\1.txt");
        Scanner scanfile = new Scanner(file);
        while(scanfile.hasNext()){
            System.out.println(scanfile.next());
        }


    }

}
