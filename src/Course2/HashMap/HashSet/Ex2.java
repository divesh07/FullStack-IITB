package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Ex2 {
    public static void main(String[] args) {

        // creating a HashSet named "hashSet"
        Set<Integer> hashSet = new HashSet<Integer>();

        // adding elements to the hashSet
        hashSet.add(6);
        hashSet.add(6);

        // removing the element 6 from the hashset
        hashSet.remove(6);

        System.out.println(hashSet.contains(6));

    }
}
