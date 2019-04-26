package Module2;

public class Day {
    public static void main(String[] args) {
        int day = 5;
        if (day >= 1 && day <= 5) {
            System.out.print("Time to wake up early. We have work today. ");
            if (day == 5) {
                System.out.print("Don't forget to bring snacks for co-workers!");
            }
        } else if (day == 6 || day == 7) {
            System.out.print("Time to sleep in. No work today.");
        }
    }
}
