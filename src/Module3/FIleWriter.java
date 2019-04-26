import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class FIleWriter {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter("C:\\Temp\\2.txt");
            fileWriter.write("abc");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileWriter != null) {
                    fileWriter.flush();
                    fileWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        int x;
        x = 0;
        int y = -1;
        if ( x/ y >0 ){
            System.out.println("done");
        }

    }

}

