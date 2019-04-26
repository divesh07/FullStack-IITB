import java.util.*;

public class LngestPrefix {
    public static ArrayList startValues = new ArrayList();
    public static void main(String args[]) {
        String[] elements = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl",
                "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr",
                "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs",
                "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W",
                "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np",
                "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg",
                "Cn", "Uut", "Uuq", "Uup", "Uuh", "Uus", "Uuo"};

        Scanner myScanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String inputWord = myScanner.next();
        String chemWord = spellWord(inputWord, elements);
        System.out.println(chemWord);
        myScanner.close();
    }

    public static int containsCaseInsensitive(String s, String[] elements) {
        int index = -1;
        boolean found = false;
        for (String string : elements) {
            index++;
            if (string.equalsIgnoreCase(s)) {
                System.out.println("Element found " + s);
                found = true;
                return index;
            }
        }
        if (!found) {
            System.out.println("Element Not found " + s);
            return -1;
        }
        return index;
    }

    public static int getMaxLength(String[] elements) {
        int max = 0;
        for (String s : elements) {
            if (s.length() > max) {
                max = s.length();
            }
        }
        System.out.println("Max length " + max);
        return max;
    }

    public static boolean findMatchedResult(ArrayList start, ArrayList end , String word , ArrayList allMatches){
        int length = word.length();
        System.out.println("Length : " + length);
        // Rule 1 ( Start index should have 0
        if (start.contains(0)){
            System.out.println("Start index found");
        }else{
            return false;
        }
        // Rule 2 ( End index should have length
        if ( end.contains(length)){
            System.out.println("End Index found");
        }else{
            System.out.println("End Index missing");
            return false;
        }
        // Rule 3 : Start - End should have mapping from
        int index = end.indexOf(length);
        System.out.println("End Index" + index);
        startValues.add(allMatches.get(index));
        // get key of the start at the index til it s zero
        boolean flag = true;
        while(flag){
             int x = (int) start.get(index);
             System.out.println("start value" + x);
             if ( x == 0 ){
                 flag = true;
                 break;
             }else{
                 index = end.indexOf(x);
                 startValues.add(allMatches.get(index));
             }
        }
        return true;
    }

    public static String spellWord(String word, String[] elements) {
        // write your code here to spell word with element abbreviations
        ArrayList matched = new ArrayList();
        ArrayList allStartIndex = new ArrayList();
        ArrayList allEndIndex = new ArrayList();
        boolean flag = false;
        System.out.println(Arrays.toString(elements));
        int maxLength = word.length();
        int maxSearchLength = getMaxLength(elements);

        for (int i = 0; i <= word.length(); i++) {
            System.out.println("i" + i);
            int j = i + 1;
            // Find Longest match
            while ((j <= word.length()) ) {
                System.out.println("i" + i + "j" + j);
                int index = containsCaseInsensitive(word.substring(i, j), elements);
                if (index >=0){
                    //System.out.println(elements[index]);
                    matched.add(elements[index]);
                    allStartIndex.add(i);
                    allEndIndex.add(j);
                }
                j++;
            }
            //System.out.println("i" + i + "j" + j);
        }
        if (findMatchedResult(allStartIndex, allEndIndex, word, matched)) {
            Collections.reverse(startValues);
            System.out.println(startValues.toString());
            System.out.println("All matches " + matched.toString());
            System.out.println("Start Index " + allStartIndex.toString());
            System.out.println("End Index" + allEndIndex.toString());
            return startValues.toString();
        }else{
            return "could not convert to chemical stting";
        }
    }
}

