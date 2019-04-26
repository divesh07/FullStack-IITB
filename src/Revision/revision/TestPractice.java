package revision;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TestPractice {

}

class StackTest{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.peek());
        stack.add(2, 4);
        stack.add(3, 5);
        stack.add(4, 6);
        System.out.println(stack.peek());
        System.out.println(stack.empty());
        Iterator itr = stack.iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println("Element at " + stack.search(6));
    }
}
class QueueTest{

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        System.out.println(queue.isEmpty());
        queue.add(1);
        queue.add(3);
        //((LinkedList<Integer>) queue).add(0, 2);
        //System.out.println(queue.poll());
        System.out.println(((LinkedList<Integer>) queue).pop());
        queue.add(4);
        queue.add(5);
        System.out.println(queue.size());
        System.out.println(queue.peek());

    }

}
