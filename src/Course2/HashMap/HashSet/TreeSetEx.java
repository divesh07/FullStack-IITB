package HashSet;

import sun.reflect.generics.tree.Tree;

import java.util.TreeSet;

public class TreeSetEx {
    public static void main(String args[]) {
        // create a TreeSet named "tSet"
        TreeSet<String> tSet = new TreeSet<String>();
        // adding elements to it
        tSet.add("4");
        tSet.add("2");
        tSet.add("7");
        tSet.add("5");
        tSet.add("9");

        // printing the TreeSet
        System.out.println(tSet);
    }
}
