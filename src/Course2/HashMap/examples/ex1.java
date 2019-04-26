package examples;

import java.util.HashMap;

public class ex1 {
    public static void main(String[] args) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        h.put('a', 3);
        h.put('b', 2);
        System.out.print(h.containsKey('a') + " ");
        System.out.print(h.get('a') + " ");
        h.remove('a');
        System.out.print(h.containsKey('a') + " ");
        h.clear();
        System.out.print(h.isEmpty() + " ");
    }
}
