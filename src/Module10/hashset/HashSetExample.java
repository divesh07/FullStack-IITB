package hashset;

import java.util.*;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> fruits = new HashSet<>();

        // add
        fruits.add("Apple");
        fruits.add("Banana");

        //isEmpty
        System.out.println("is fruit set empty " + fruits.isEmpty());

        //contains
        System.out.println("does set contain elemeent Apple " + fruits.contains("Apple"));
        System.out.println("does set contain elemeent Mango " + fruits.contains("Mango"));

        //remove
        System.out.println("apple removed from the list" + fruits.remove("Apple"));
        System.out.println("mango removed from the list" + fruits.remove("Mango"));

        //size example
        System.out.println("fruits set size = "+fruits.size());

        // add All
        List<String> list = new ArrayList<>();
        list.add("Apple");list.add("Apple");
        list.add("Banana"); list.add("Mango");

        System.out.println("fruits set before add all" + fruits);
        fruits.addAll(list);
        System.out.println("fruits set after add all" + fruits);

        Iterator<String> iterator = fruits.iterator();
        while(iterator.hasNext()){
            String fruit = iterator.next();
            System.out.println("processing" + fruit);
            if ("Mango".equals(fruit)){
                //fruits.remove("Mango"); // Would throw java.util.ConcurrentModificationException
                iterator.remove();
            }
        }

        System.out.println("fruits after iteration " + fruits);

    }
}
