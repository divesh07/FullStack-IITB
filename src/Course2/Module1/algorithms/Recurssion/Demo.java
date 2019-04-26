package algorithms.Recurssion;

public class Demo {
    int i = 1;

    int function() {
        if (i <= 5) {
            System.out.print(i++ + " ");
            function();
        }
        return 0;
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.function();
    }
}
