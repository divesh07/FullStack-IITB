package hashset;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetToListExample {
    public static void main(String[] args) {
        Set<String> vowels = new HashSet<>();
        vowels.add("a");vowels.add("e");vowels.add("i");

        // set to list example
        List<String> vowelList = new ArrayList<>(vowels);
        vowelList.add("o");
        vowelList.add("a");
        vowelList.add("u");
        System.out.println(vowelList);

        // list to set
        vowels = new HashSet<>(vowelList);
        System.out.println(vowels);



    }
}
