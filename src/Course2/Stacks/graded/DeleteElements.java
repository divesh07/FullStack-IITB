package graded;

import java.util.Scanner;
import java.util.Stack;

public class DeleteElements {

    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        deleteFirstHalf(stack);
    }

    // Method to delete the first half of the elements from the bottom of the stackand print the remaining elements
    static void deleteFirstHalf(Stack<Integer> stack) {
        // Write your code here
        if ( stack.isEmpty()){
            return;
        }

        if ( stack.size() <=1){
            System.out.println(stack);
            return;
        }else{
            Stack<Integer> reverse = new Stack<>();
            int mid = stack.size()/2;
            while(stack.size() != mid){
                reverse.push(stack.pop());
            }
            stack.clear();

            while(!reverse.isEmpty()){
                stack.push(reverse.pop());
            }
            System.out.println(stack);
        }
    }
}
