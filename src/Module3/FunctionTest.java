public class FunctionTest {

    /*public static void main(String args[]) {
        int num = 6;
        increaseNum(6);
        System.out.print(num);
    }

    public static void increaseNum(int number) {
        number++;
        System.out.print(number);
    }
    */

    public static void main(String args[]) {
        boolean check = true;
        functionA(check);
        System.out.print(check && !functionA(check));
    }

    public static boolean functionA(boolean a) {
        return !a;
    }


}
