package arrayList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ArrayListSortingExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) ints.add(random.nextInt(1000));
        System.out.println("Original List: "+ints);

        //sort the list
        MyComparator c = new ArrayListSortingExample(). new MyComparator();
        ints.sort(c);
        System.out.println("Sorted in Increasing Order: "+ints);

        //lambda example, sort
        ints.sort( (o1,o2) ->{
            return (o1-o2);
        });
        System.out.println("Sorted in Increasing Order: "+ints);

        //lambda example, sort in reverse order
        ints.sort( (o1,o2) ->{
            return (o2-o1);
        });
        System.out.println("Sorted in Decreasing Order: "+ints);
    }

    class MyComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return (o1 - o2);
        }
    }
}
