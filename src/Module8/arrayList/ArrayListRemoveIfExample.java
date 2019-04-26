package arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ArrayListRemoveIfExample {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < 10; i++) ints.add(i);
        Predicate<Integer> filter = new ArrayListRemoveIfExample(). new MyPredicate();
        ints.removeIf(filter);
        System.out.println(ints);

        //lambda expression, remove elements divisible by 3
        ints.removeIf(x->{
            return x%3 ==0;
        });
        System.out.println(ints);
    }

    class MyPredicate implements Predicate<Integer>{

        @Override
        public boolean test(Integer integer) {
            return integer%2 == 0;
        }
    }

}
