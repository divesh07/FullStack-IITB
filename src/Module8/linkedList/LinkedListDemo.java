package linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List names = new LinkedList();
        names.add("Rama");
        names.add("Shyam");
        names.add("Chini");
        names.add(2011);
        System.out.println(names);
        System.out.println(names.size());
    }
}

