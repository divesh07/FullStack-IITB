import java.util.Scanner;
import java.util.Stack;

public class PrintElement {
    //print the fifth element from the top of the stack.
    // Stack(bottom -> top)= [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0) {
            //System.out.println("value" + n);
            stack.push(s.nextInt());
        }
        printFifthElementFromEnd(stack);
    }

    // Method to print the fifth element from the top of the stack
    static void printFifthElementFromEnd(Stack<Integer> stack) {
        // Write your code here
        if (stack.size() >= 5) {
            System.out.println(stack.get(stack.size()-5));
        } else {
            System.out.println("There are not enough elements in the stack");
        }
    }
}
