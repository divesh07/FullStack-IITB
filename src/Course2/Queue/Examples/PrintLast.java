package Examples;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintLast {

    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        printFifthElementFromEnd(queue);
    }

    // Method to print the fifth element from the tail of the queue
    static void printFifthElementFromEnd(Queue<Integer> queue) {
        // Write your code here
        if (queue.size() <5){
            System.out.println("There are no enough elements in the queue");
            return;
        }else{
            int elementsToRemove = queue.size() - 5;
            for ( int i=1 ; i <= elementsToRemove ; i++){
                queue.remove();
            }
            System.out.println(queue.peek());
        }
    }
}
