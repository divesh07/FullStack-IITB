package performance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class largeList {
    public static void main(String[] args) {

        List<Integer> list1 = new ArrayList<>();
        for ( int i = 0 ; i < 100000; i++){
            list1.add(i);
        }

        List<Integer> list2 = new LinkedList<>();
        for ( int i = 0 ; i < 100000; i++){
            list2.add(i);
        }

        // for get operations Array list is significantly faster than linkedlist
        long time1 = estimatePerformanceGet(list1);
        long time2 = estimatePerformanceGet(list2);
        System.out.println("Arraylist took " + time1 );
        System.out.println("Linkedlist took " + time2 );
        System.out.println(" Array list faster in Get Operation by  " + (time2/time1));

        // for Add operations Linked  list is significantly faster than Arraylist
        // adding elements to the beginning
        time1 = estimatePerformanceAdd(list1);
        time2 = estimatePerformanceAdd(list2);
        System.out.println("Arraylist took " + time1 );
        System.out.println("Linkedlist took " + time2 );
        System.out.println("Linked list faster in Add / Remove Operations by "+ (time1/time2));

    }

    public static long estimatePerformanceGet(List<Integer> list){
        final long start = System.nanoTime();
        for ( int i = 0 ; i < 100000; i++){
            list.get(list.size()/2);
        }
        final long end = System.nanoTime();
        return end - start;
    }

    public static long estimatePerformanceAdd(List<Integer> list){
        final long start = System.nanoTime();
        for ( int i = 0 ; i < 100000; i++){
            list.add(0,i);
        }
        final long end = System.nanoTime();
        return end - start;
    }
}
