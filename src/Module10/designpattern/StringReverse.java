package designpattern;

import com.company.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StringReverse {
    public static void main(String[] args) {
        String str = "cba";
        System.out.println(str);
        char[] charArray = str.toCharArray();
        System.out.println(charArray);
        List<Character> reverse = new ArrayList<>();
        for(char c : charArray){
            reverse.add(c);
        }
        Collections.reverse(reverse);
        System.out.println(reverse);
        //System.out.println(str.length());
        String str2 = "";
        for(int i = str.length()-1 ; i >= 0 ; i-- ){
            str2 += str.charAt(i);
            //System.out.println(str2);
        }
        System.out.println(str2);
    }
}
