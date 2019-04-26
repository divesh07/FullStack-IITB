public class NestedLoopTest {
    public static void main(String args[]) {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 1; k <= 10; k++) {
                    System.out.println("Hello");
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
