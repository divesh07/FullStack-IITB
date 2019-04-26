package Examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Reverse {
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void func() {
        //write your code here
        if (q.size() <=1){
            return;
        }else{
            Stack<Integer> stack = new Stack<>();
            while (!q.isEmpty()) {
                stack.add(q.peek());
                q.remove();
            }
            while(!stack.isEmpty()){
                q.add(stack.peek());
                stack.pop();
            }
        }
    }

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int j = 0; j < n; j++) {
            q.add(in.nextInt());
        }
        func();
        System.out.println(q);
    }
}
