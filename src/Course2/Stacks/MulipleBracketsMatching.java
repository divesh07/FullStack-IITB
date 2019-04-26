import java.util.ArrayList;
import java.util.List;

public class MulipleBracketsMatching {

    public static void main(String[] args) {
        try {
            System.out.println(match("(()")); // not balanced
            System.out.println(match("{{}}")); //balanced
            System.out.println(match("(){}")); //balanced
            System.out.println(match("(({}())")); // not balanced
            System.out.println(match("{{()}}")); // balanced
            System.out.println(match("{{(})}")); // Incorrect/not balanced, but identified as correct by the algorithm below
        } catch (Exception e) {
            // catch the exception thrown by the method match() in try block;
            // e.getMessage() will get the exception message
            System.out.println(e.getMessage());
        }
    }

    public static boolean match(String parens) throws Exception {
        int count1 = 0, count2 = 0; List<String> lastUsed ;
        lastUsed = new ArrayList<String>();
        char[] chars = parens.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                    count1++;
                    lastUsed.add("c1");
                    break;
                case ')':
                    if (count1 > 0 && lastUsed.get(lastUsed.size()-1).equalsIgnoreCase("c1")) {
                        count1--;
                        lastUsed.remove(lastUsed.size()-1);
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    count2++;
                    lastUsed.add("c2");
                    break;
                case '}':
                    if (count2 > 0 && lastUsed.get(lastUsed.size()-1).equalsIgnoreCase("c2")) {
                        count2--;
                        lastUsed.remove(lastUsed.size()-1);
                    } else {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        if (count1 == 0 && count2 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
