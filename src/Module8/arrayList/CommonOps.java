package arrayList;

import java.util.ArrayList;
import java.util.List;

public class CommonOps {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<>();

        letters.add("A");
        letters.add("B");
        letters.add("A"); // can contain duplicates

        System.out.println(letters);

        letters.add(2,"C"); // add element at index
        System.out.println(letters);

        List<String> list = new ArrayList<>();
        list.add("E");
        list.add("F");
        list.add("G");

        letters.addAll(list); // add collection list
        System.out.println(letters);

        letters.clear(); // empty
        System.out.println(letters);

        letters.add("A");
        letters.add("B");

        letters.addAll(1, list); // add collection list at specific index between A and B
        System.out.println(letters);

        System.out.println(letters.contains("E"));

        System.out.println(letters.get(3));

        letters.retainAll(list);
        System.out.println(letters); // removes all the other elements except the collection


    }
}

