public class SwtichTest {
    public static void main(String[] args) {
        char grade = 'A';
        switch (grade) {
            case 'A':
                System.out.print("Good Performance. ");
            case 'E':
                System.out.print("Failed this time; do well next time. ");
            default:
                System.out.print("Invalid grade entered. ");
        }
    }
}
