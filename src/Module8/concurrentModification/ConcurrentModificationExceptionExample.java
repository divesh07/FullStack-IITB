package concurrentModification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        List<String> myList = new CopyOnWriteArrayList<>();
        myList.add("1");
        myList.add("2");
        myList.add("3");
        myList.add("4");
        myList.add("5");

        Iterator<String> it = myList.iterator();
        while ((it.hasNext())){
            String value = it.next();
            System.out.println(value);
            if(value.equalsIgnoreCase("3")){
                myList.remove("4");
                myList.add("6");
                myList.add("7");
            }
        }

        System.out.println("list size " + myList.size());
        System.out.println(myList);

        Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1","1");
        myMap.put("2","2");
        myMap.put("3","3");

        Iterator<String> it1 = myMap.keySet().iterator();
        while(it1.hasNext()){
            String key = it1.next();
            System.out.println(myMap.get(key));
            if(key.equals("1")){
                myMap.remove("3");
                myMap.put("4","4");
                myMap.put("5","5");
            }
        }

        System.out.println("map size" + myMap.size());

        List<String> names = new ArrayList<>();
        names.add("Java");
        names.add("PHP");
        names.add("SQL");
        names.add("Angular 2");

        List<String> first2Names = names.subList(0, 2);
        System.out.println(names + " , " + first2Names);
        names.set(1, "JavaScript");
        // check the output below. :)
        System.out.println(names + " , " + first2Names);

        // Let's modify the list size and get ConcurrentModificationException
        names.add("NodeJS");
        //System.out.println(names + " , " + first2Names); // this line throws exception

    }
}
