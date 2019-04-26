import java.util.*;

public class Anagram {
    //Method to check if two strings are anagram of each other or not
    public static boolean check(String str1, String str2){
        char[] ch1 = str1.toLowerCase().toCharArray();
        char[] ch2 = str2.toLowerCase().toCharArray();
        //Write your code here
        // Get lenghts of both strings
        int n1 = ch1.length;
        int n2 = ch2.length;

        // If length of both strings is not same,
        // then they cannot be anagram
        if (n1 != n2)
            return false;

        // Sort both strings
        Arrays.sort(ch1);
        Arrays.sort(ch2);

        // Compare sorted strings
        for (int i = 0; i < n1; i++)
            if (ch1[i] != ch2[i])
                return false;

        return true;
    }


    public static void main(String[] x){
        Map<String,String> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String key;
        String value;
        for(int i = 1; i <= num; i++){
            key = sc.next();
            value = sc.next();
            map.put(key,value);
        }

        HashSet<String> tmp = new HashSet<>();

        //Write your code here
        for( String keys : map.keySet()){
            if (check(keys, map.get(keys))){
                tmp.add(keys);
            }
        }
        if (tmp.size() > 0) {
            List<String> sortedList = new ArrayList<>(tmp);
            Collections.sort(sortedList);
            for (String print : sortedList) {
                System.out.println(print + " : " + map.get(print));
            }
        }else{
            System.out.println(false);
        }

    }
}
