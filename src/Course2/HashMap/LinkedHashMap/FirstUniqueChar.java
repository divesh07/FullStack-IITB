package LinkedHashMap;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FirstUniqueChar {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] charArr = str.toCharArray();
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        boolean found = false;
        for (char c : charArr) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                val++;
                map.put(c, val);
            } else {
                map.put(c, 1);
            }
        }
        //System.out.println(map.toString());
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                System.out.println(c);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("-1");
        }
    }
}

