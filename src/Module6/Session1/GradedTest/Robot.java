package GradedTest;

public class Robot {
    // Other code here

    public Robot() {
        // default constructor code here
    }

    // draw a line from current location to the location specified
    public void passLocation(int x, int y) {
        // more code
        System.out.println(x + " " + y);
    }

    public static void main(String[] args) {
        Robot r = new Robot();
        r.passLocation(5,5);
    }
}
