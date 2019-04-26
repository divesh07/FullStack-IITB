import java.util.Scanner;
import java.util.Stack;

public class PrintBottom {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        printFifthElementFromStart(stack);
    }

    // Method to print the fifth element from the bottom of the stack
    static void printFifthElementFromStart(Stack<Integer> stack) {
        // Write your code here
        if (stack.size() >= 5) {
            System.out.println(stack.get(4));
        } else {
            System.out.println("There are not enough elements in the stack");
        }
    }
}
