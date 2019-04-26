package Module2.Session3;

public class Assign3 {
    public static void main(String[] args) {
        int[] array = { 1,2,3,4,5};
        printBackwards(array);
    }
    public static void printBackwards(int[] numbers) {
        for(int i=numbers.length-1; i >= 0; i--) {
            System.out.println(numbers[i]);
        }
    }
}
