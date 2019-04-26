import java.util.Stack;

public class Example {

    private static Stack<Integer> stack = new Stack<Integer>();

    public static void main(String[] args) {
        stack.push(5);
        stack.push(3);
        stack.push(4);
        stack.pop();
        System.out.println(stack.peek());
        stack.push(9);
        System.out.println(stack);
    }
}
