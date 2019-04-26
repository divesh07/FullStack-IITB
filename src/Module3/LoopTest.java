public class LoopTest {
    public static void main(String args[]) {
        int count=0;
        for (int i = 0; i < 5; i++) {
            for (int k = 0; k <= i; k++) {
                count++;
            }
        }
        System.out.println(count);
    }
}
