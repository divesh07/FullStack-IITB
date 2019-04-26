package arrayList;

import java.util.ArrayList;
import java.util.List;

public class Constuctor {
    public static void main(String[] args) {
        // default constuctor // default capacity = 10
        ArrayList<String> vowels = new ArrayList<String>();

        // ArrayList const with initial capacity
        ArrayList<String> dictWordList = new ArrayList<String>(3);

        vowels.add("A");
        vowels.add("E");
        vowels.add("I");
        vowels.add("O");
        vowels.add("U");

        // Creating list from different collection resource:
        ArrayList<String> myList = new ArrayList<String>(vowels);
        dictWordList.addAll(vowels);

        print(myList);

    }

    public static void print(ArrayList<String> list){
        for(String str : list){
            System.out.println(str);
        }
    }
}

