import java.util.PriorityQueue;

public class RemovePoll {

    public static void priorityQueue(int[] a , int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for ( int x : a )
            pq.add(x);
        while (k-- > 0){
            System.out.println(pq.remove());
            pq.remove(k);
        }

    }
    public static void main(String[] args) {

    }

}
