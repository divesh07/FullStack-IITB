package arrayList;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSubListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Pankaj"); names.add("David");names.add("Lisa");names.add("Meghna");

        List<String> first2Names = names.subList(0, 2);

        System.out.println(names +" , "+first2Names);

        names.set(1, "Kumar");
        //check the output below. :)
        System.out.println(names +" , "+first2Names);

        first2Names.add("Megan"); //this is fine
        System.out.println(names +" , "+first2Names); //this is fine

        //Let's modify the list size and get ConcurrentModificationException
        names.add("Deepak");
        System.out.println(names +" , "+first2Names); //this line throws exception

    }

}
