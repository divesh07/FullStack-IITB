package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> letters = new ArrayList<String>();

        //add example
        letters.add("A");
        letters.add("C");
        letters.add("D");

        //let's insert B between A and C
        letters.add(1,"B");
        System.out.println(letters);

        List<String> list = new ArrayList<String>();
        list.add("E");
        list.add("H");

        //appending list elements to letters
        letters.addAll(list);
        System.out.println(letters);

        //clear example to empty the list
        list.clear();
        list.add("F");list.add("G");

        letters.addAll(5,list);
        System.out.println(letters);

        //contains example
        System.out.println("Letters list contains E ? "+letters.contains("E"));
        System.out.println("Letters list contains Z ? "+letters.contains("Z"));

        ArrayList<String> tempList = new ArrayList<>();
        tempList.ensureCapacity(1000);

        //indexOf example
        System.out.println("First index of D = "+letters.indexOf("D"));

        //remove all matching elements between letters and list
        letters.removeAll(list);
        System.out.println(letters);

        //retainAll example
        list.clear();list.add("A");list.add("B");list.add("C");
        letters.retainAll(list);
        System.out.println("letters elements after retainAll operation: "+letters);

        //size example
        System.out.println("letters ArrayList size = "+letters.size());

        //set example
        letters.set(2, "D");
        System.out.println(letters);

        String[] strArray = new String[letters.size()];
        strArray = letters.toArray(strArray);
        System.out.println(Arrays.toString(strArray));

    }
}
