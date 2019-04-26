import java.util.Scanner;
import java.util.Stack;

public class ReverseString {

    public static void main(String arg[]) {
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        //write your code here
        char[] charArray = data.toCharArray();
        for( char c : charArray){
            s.push(c);
        }
        //System.out.println(s);
        //System.out.println(s.isEmpty());

        String reverse = "";
        while(!s.isEmpty()){
            reverse += s.pop();
        }
        System.out.println(reverse);
    }

}
