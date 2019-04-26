package List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test {

    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);numberList.add(2);numberList.add(3);
        iterate(numberList);
    }

    public static void iterate (List<Integer> numberList) {

        ListIterator<Integer> it = numberList.listIterator(2);
        System.out.println(it.next());

    }
}

