import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Stack;

public class StackParanthesisMatching {

     /*
       NOTE
       ----
       We implement the parenthesis matching algorithm using a stack.
     */

    // you could also initialise the stack from the inbuilt class
    // private static Stack<Character> stack = new Stack<Character>();

    private static Stack<Character> stack = new Stack<Character>();
    public static void main(String[] args) {
        try {
            /*System.out.println(match("()"));
            System.out.println(match("((((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((((()))))))"));
            System.out.println(match("(((()(((()))))))"));*/
            System.out.println(match("((())))"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean match(String parens) throws Exception {
        for (char c : parens.toCharArray()) {
            if (c == '(') {
                stack.push('(');
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                throw new Exception("Unexpected character " + c);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

}

