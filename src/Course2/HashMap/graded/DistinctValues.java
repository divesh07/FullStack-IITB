package graded;

import java.util.*;

public class DistinctValues {
    public static void printValues(Map<Integer,String> map){
        //Write your code here
        LinkedHashSet<String> set = new LinkedHashSet<>();
        for(Integer i: map.keySet()){
            set.add(map.get(i));
        }

        for(String s: set){
            System.out.print(s + " ");
        }
    }

    public static void main(String[] x){
        Map<Integer,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 1 ){
            return;
        }
        int key;
        String value;
        for(int i = 1; i <= num; i++){
            key = sc.nextInt();
            value = sc.next();
            map.put(key,value);
        }
        printValues(map);
    }
}
