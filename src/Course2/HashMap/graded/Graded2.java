package graded;

import java.util.HashMap;

public class Graded2 {
    public static void main(String[] args) {
        HashMap<Integer,String> hash= new HashMap<Integer,String>();
        hash.put(5, "Hello");
        System.out.println(hash.get(5));
        System.out.println(hash.get("Hello"));


    }
}
