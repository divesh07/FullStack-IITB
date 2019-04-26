package PracticeQuestions;

import java.util.Scanner;
import java.util.Stack;

public class Sort {

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        sort(stack);
    }

    // Method to sort the elements of the stack in ascending order
    static void sort(Stack<Integer> stack) {
        // Write your code here
        Stack<Integer> tmp = new Stack<>();
        int max = 0;
        while (!stack.isEmpty()) {
            try {
                if(stack.empty() && !tmp.empty()){
                    max = tmp.pop();
                }else {
                    max = stack.pop();
                }
                // push the item from tmp to main stack
                while (!tmp.isEmpty() && tmp.peek() > max) {
                        stack.push(tmp.pop());
                }
                tmp.push(max);
            }catch (Exception ex){
                break;
            }
        }
        System.out.println(tmp);
    }
}
