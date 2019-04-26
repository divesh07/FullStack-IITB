package Module2.Session3;

public class StringUpperCase {

    public static void main(String[] args) {
        String string1 = "Welcome";
        uppercase(string1);
        System.out.println(string1);
    }

    public static String uppercase(String string1) {
        string1.toUpperCase();
        return string1;
    }
}