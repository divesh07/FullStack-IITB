package PracticeQuestions;

import java.util.Scanner;
import java.util.Stack;

public class Reverse {

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        reverseSecondHalf(stack);
    }

    // Method to reverse the last half of the elements from the bottom of the stack
    static void reverseSecondHalf(Stack<Integer> stack) {
        // Write your code here
        System.out.println("Stack size"+ stack.size());
        int mid = 0;
        if (stack.size()%2 == 0) {
            mid = stack.size() / 2;
        }else{
            mid = (stack.size()+1) / 2;
        }
        System.out.println("Mid element " + mid);
        Stack<Integer> s2 = new Stack<>();
        while(stack.size() > mid && !stack.isEmpty()) {
            s2.push(stack.pop());
        }
        s2 = reverse(s2);
        while(!s2.isEmpty()){
            stack.push(s2.pop());
        }
        System.out.println(stack);
    }

    static Stack<Integer> reverse(Stack<Integer> stack){
        Stack<Integer> s2 = new Stack<>();
        while(!stack.isEmpty()){
            s2.push(stack.pop());
        }
        return s2;
    }
}
