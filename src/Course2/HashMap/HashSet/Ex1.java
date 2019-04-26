package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Ex1 {
    public static void main(String[] args) {
        // 1. Creating a HashSet named "hashSet"
        Set<Integer> hashSet = new HashSet<Integer>();

        // 2. Adding the elements to the hashSet
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        hashSet.add(4);

        // 3. Adding the the element 3 again to the hashSet
        hashSet.add(3);

        /* 4. Checking whether the hashSet contains the
        element 2 or not, and print "2 is contained" */
        if( hashSet.contains(2)){
            System.out.println("2 is contained");
        }
        // else print "2 is not contained"
        else{
            System.out.println("2 is not contained");
        }

        // 5. Now, remove element 3 from the hashSet
        hashSet.remove(3);

        /* 6. Check whether the element 3 is present in
        the hashSet or not, and print the result */
        System.out.println(hashSet.contains(3));
    }

}
