public class TryCatchTest {
    public static void main(String args[]) {
        try {
            System.out.println(67/0);
        } catch (Exception e) {
            System.out.println("Cannot divide by 0");
        }
    }
}
