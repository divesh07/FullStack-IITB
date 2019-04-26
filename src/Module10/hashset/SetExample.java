package hashset;

import java.util.HashSet;

public class SetExample {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        java.util.Set<String> set1 = new HashSet<>();

        // with initial capacity ( should be power odf 2)
        set = new HashSet<>(32);

        set = new HashSet<>(32,0.80f);

        // creating hasset from another collection
        set = new HashSet<>(set1);
    }
}


