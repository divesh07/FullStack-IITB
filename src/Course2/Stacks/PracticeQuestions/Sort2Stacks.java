package PracticeQuestions;

import com.sun.javafx.image.IntPixelGetter;

import java.util.Stack;

public class Sort2Stacks {
    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stack1.push(4);stack1.push(6);stack1.push(9);
        stack2.push(1);stack2.push(5);stack2.push(7);

    }

    public static void sortStacks(Stack s1 , Stack s2) {
        Stack<Integer> s3 = new Stack<>();
        while(!s1.isEmpty() && !s2.isEmpty()){
            if ((int)s1.peek() > (int)s2.peek()){
                s3.push((Integer)s1.pop());
            }else{
                s3.push((Integer)s2.pop());
            }
        }

        while(!s1.isEmpty()){
            s3.push((Integer)s1.pop());
        }

        while(!s2.isEmpty()){
            s3.push((Integer)s2.pop());
        }

    }
}
