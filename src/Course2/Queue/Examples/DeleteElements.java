package Examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeleteElements {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        deleteSecondHalf(queue);
    }

    // Method to delete the second half of the elements and print the remaining elements
    static void deleteSecondHalf(Queue<Integer> queue) {
        // Write your code here
        if(queue.size()<= 1){
            System.out.println(queue);
            return;
        }
        Queue<Integer> halfedQueue = new LinkedList<Integer>();
        int mid = 0;
        if (queue.size() % 2 == 0) {
            mid = queue.size() / 2;
        }else{
            mid = (queue.size() / 2) + 1;
        }
        //System.out.println(mid);
        for (int i =1 ; i <= mid ; i++){
            halfedQueue.add(queue.remove());
        }
        System.out.println(halfedQueue);
    }

}
