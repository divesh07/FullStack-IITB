public class ConditionTest {
    public static void main(String[] args) {
        int scores = 92;
        String nationality = "Japanese";

        boolean a = (scores > 90); //true
        boolean b = (nationality.equals("Indian")); //false
        boolean c = scores > 95; //false

        if (scores <= 100) {
            if (!((a && b) || (!b && c))) {
                System.out.println("Output 1");
            } else {
                System.out.println("Output 2");
            }
        } else {
            System.out.println("Invalid Score");
        }
    }
}
