package hashset;

import java.util.*;

public class source {
    public static void main(String[] args) {
        // set to list
        Set <String> settoList = new HashSet<>();
        settoList.add("a");
        settoList.add("b");
        settoList.add("c");

        List<String> list = new ArrayList<>(settoList);

        System.out.println(list);
        list.add("c");
        list.add("e");

        // list to set
        settoList = new HashSet<>(list);
        System.out.println(settoList);


        // set to array
        Set<Integer> settoInt = new HashSet<>();
        settoInt.add(1);
        settoInt.add(2);
        settoInt.add(3);


        Integer[] intArray = new Integer[settoInt.size()];
        intArray = settoInt.toArray(intArray);
        System.out.println(Arrays.toString(intArray));

        // array to set
        settoInt = new HashSet<>(Arrays.asList(intArray));
        settoInt.add(1);
        settoInt.add(4);
        System.out.println(settoInt);
    }
}
