package Module2;

public class Multiple {
    public static void main(String[] args) {
        int num=1;
        boolean keepRunning = true;

        while(keepRunning == true) {
            if(num%17 == 0) {
                System.out.println(num);
                keepRunning = false;
            } else {
                System.out.println(num);
            }
            num++;
        }
    }
}
