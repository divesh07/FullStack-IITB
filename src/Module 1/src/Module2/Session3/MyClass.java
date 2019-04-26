package Module2.Session3;

public class MyClass {

    public static void print(String var1, int var2) {
        for (int i = 0; i < var2; i++) {
            System.out.println(var1 + " " + i);
        }
    }

    public static void main(String[] args) {
        String var1 = "Hello";
        int var2 = 4;
        print(var1, var2);
    }
}
