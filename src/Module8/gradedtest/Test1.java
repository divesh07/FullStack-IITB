package gradedtest;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Test1{
    public static void main(String[] args) {
        List<Integer> numberList = new ArrayList<>();
        numberList.add(1);
        numberList.add(2);
        numberList.add(3);
        numberList.add(4);
        numberList.add(5);
        numberList.add(6);
        //process1(numberList);
        //process2(numberList);
        //iterate(numberList);
        //iterate2(numberList);

        List<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);

        ListIterator<Integer> listIterator = arrayList.listIterator();
        while(listIterator.hasNext()) {
            System.out.print(listIterator.next());
            listIterator.previous();
        }
    }

    public static void process1(List<Integer> numberList){
        numberList.add(2, 5);
        System.out.println(numberList.get(2));
    }

    public static void process2(List<Integer> numberList){
        numberList.add(2, 5);
        numberList.remove(1);
        System.out.println(numberList.get(3));
    }

    public static void iterate (List<Integer> numberList) {
        ListIterator<Integer> it = numberList.listIterator(1);
        it.next();
        it.next();
        it.previous();
        System.out.println(it.next());
    }

    public static void iterate2(List<Integer> num) {
        ListIterator<Integer> it = num.listIterator(num.size());
        while(it.hasPrevious()) {
            if(it.hasPrevious()) {
                System.out.println(it.previous());
            }
            it.previous();
        }
    }

}
