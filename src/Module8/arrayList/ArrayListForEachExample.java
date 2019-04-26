package arrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ArrayListForEachExample {

    public static void main(String[] args) {
        List<String> stocks = new ArrayList<>();
        stocks.add("Google"); stocks.add("Apple");
        stocks.add("Microsoft"); stocks.add("Facebook");

        Consumer<Object> consumer = new ArrayListForEachExample().new
                MyConsumer();

        stocks.forEach(consumer);

        //lambda style
        stocks.forEach(x-> {
            System.out.println("processed " + x);
        });


    }

    class MyConsumer implements Consumer<Object>{

        @Override
        public void accept(Object o) {
            System.out.println("Processing " + o);
        }
    }
}
