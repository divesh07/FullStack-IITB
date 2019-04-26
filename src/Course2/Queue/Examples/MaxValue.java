package Examples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxValue {
    //find the maximum element of the queue and move that element to the end of the queue.
    static Queue<Integer> q = new LinkedList<Integer>();

    public static void func() {
        //write your code here
        if (q.size() ==1){
            return;
        }
        Queue<Integer> second = new LinkedList<Integer>();
        int max = q.peek();
        while(!q.isEmpty()){
            if (q.peek()> max){
                max = q.peek();
            }
            second.add(q.remove());
        }
        //System.out.println(max);
        //System.out.println(second);

        while(!second.isEmpty()){
            if(second.peek() == max){
                second.remove();
            }else {
                //System.out.println(second.peek());
                q.add(second.remove());
            }
        }
        q.add(max);
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
