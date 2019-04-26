package examples;

import java.util.HashMap;

public class ex2 {

    private static HashMap<String, String> representationHashMap = new HashMap<>();

    public static void main(String[] args) {
        add();
        representationHashMap.put("2", "c");
        System.out.println(representationHashMap);

    }

    public static void add() {
        representationHashMap.put("1", "a");

    }

}


