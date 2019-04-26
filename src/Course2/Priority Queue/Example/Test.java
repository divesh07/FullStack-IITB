package Example;

import sun.security.provider.certpath.AdjacencyList;

import java.io.IOException;
import java.util.*;

public class Test {

    public static void function() throws RuntimeException{
        try {
            System.out.println("Starting");
            try {
                int x = 10;
                int y = 0;
                int z = x / y;
                System.out.println(x);
            } catch (RuntimeException ex) {
                throw new RuntimeException(ex.getMessage());
            }
        }catch (RuntimeException ex){

        }
    }

    public static void main(String[] args) {

        //function();
        Hashtable<String, String> x = new Hashtable<>();
        x.put("1", "2");
        x.put("2", "3");
        x.put("3", "4");
        x.put("4", "5");
        Set<String> keys = x.keySet();

        for(String key : keys){
            System.out.println(key);
            System.out.println("***");
            System.out.println(x.get(key));
            System.out.println("***");
        }


        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");
        for(String key : set){
            System.out.println(key);
        }

        Set<String> set2 = new LinkedHashSet<>();
        set2.add("b");
        set2.add("a");

        for(String key : set2){
            System.out.println(key);
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        ListIterator<Integer> itr  = stack.listIterator();
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
        System.out.println(stack.peek());

    }

}

class ArrayListTest{
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("str");
        list.add(1);
        list.add(1,"test");
        list.add("find");
        System.out.println(list.isEmpty());
        System.out.println(list.size());
        Iterator itr = list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
        System.out.println(list.get(0));
        list.remove("none");
        list.remove("find");
        list.remove(1);
        System.out.println(list.size());
    }
}

class LinkedListTest{
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(1, 2);
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());
    }
}
