package springboot.Javatest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Threading extends Thread {

    public void readFile() throws FileNotFoundException {
        File file = new File("C:\\Temp\\1.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            System.out.println(scan.next());
        }

    }
    public void run(){
        try{
            System.out.println("Thread running : " + Thread.currentThread().getId());
            readFile();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}

class Demo{
    public static void main(String[] args) {
        for ( int i = 0 ; i < 5; i++) {
            Threading obj = new Threading();
            obj.start();
        }

    }
}


