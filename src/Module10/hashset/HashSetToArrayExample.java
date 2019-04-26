package hashset;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetToArrayExample {
    public static void main(String[] args) {
        Set<Integer> ints = new HashSet<>();
        for ( int i = 0; i< 10; i++){
            ints.add(i);
        }

        System.out.println(ints);
        // set to array example
        Integer[] arr = new Integer[ints.size()];
        arr = ints.toArray(arr);
        System.out.println(Arrays.toString(arr));

        ints.remove(0);ints.remove(1);
        System.out.println(ints);
        System.out.println(Arrays.toString(arr));

        //array to set example
        ints = new HashSet<>(Arrays.asList(arr));
        System.out.println(ints);
        ints.remove(0);ints.remove(1);
        System.out.println(ints);
        System.out.println(Arrays.toString(arr));
    }
}
