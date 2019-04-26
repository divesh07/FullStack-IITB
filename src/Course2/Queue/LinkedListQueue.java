import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args) {
        Queue<Character> q=new LinkedList<>();
        System.out.println(q.isEmpty());
        q.add('a');
        q.add('b');
        q.add('c');
        q.add('d');
        System.out.println(q);
        System.out.println(q.size());
        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q);
        System.out.println(q.isEmpty());
    }

}
