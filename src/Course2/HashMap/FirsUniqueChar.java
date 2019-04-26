import java.util.HashMap;
import java.util.Scanner;

public class FirsUniqueChar {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        char[] charArr = str.toCharArray();
        //System.out.println(charArr);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : charArr){
            if ( map.containsKey(c)){
                int val = map.get(c);
                val++;
                map.put(c, val);
            }else{
                map.put(c, 1);
            }
        }
        System.out.println(map.toString());
        for (char c : charArr){
            if (map.get(c) == 1){
                System.out.println("First unique element " + c);
                break;
            }
        }


    }
}
