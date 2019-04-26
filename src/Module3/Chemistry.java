import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Chemistry {
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

    public static String longestSearch(String word, String[] elements){
        return "";
    }

    public static String spellWord(String word, String[] elements) {
        // write your code here to spell word with element abbreviations
        ArrayList matched = new ArrayList();
        boolean flag = true;
        System.out.println(Arrays.toString(elements));
        int maxLength = word.length();
        boolean isbacktracked = false;
        boolean isdoubleBackTracked = false;

        for (int i = 0; i < word.length(); i++) {
            System.out.println("i" + i);
            int index = containsCaseInsensitive(word.substring(i, i + 1), elements);
            if (index >= 0) {
                System.out.println(elements[index]);
                matched.add(elements[index]);
            } else {
                for (int j = (i == 0) ? 0 : (i - 1); j < word.length(); j = j + 2) {
                    System.out.println("j" + j);

                    index = containsCaseInsensitive(word.substring(j, j + 2), elements);
                    if (index >= 0 ) {
                        System.out.println(elements[index]);
                        if (matched.size() >= 1) {
                            matched.remove(matched.size() - 1);
                        }
                        matched.add(elements[index]);
                        break;
                    } else {
                        for (int k = (j == 0) ? 0 : (j - 1); k < word.length(); k = k + 3) {
                            System.out.println("k" + k);
                            index = containsCaseInsensitive(word.substring(k, k + 3), elements);
                            if (index >= 0 ) {
                                System.out.println(elements[index]);
                                if (matched.size() >= 1) {
                                    matched.remove(matched.size() - 1);
                                }
                                matched.add(elements[index]);
                                break;
                            } else {
                                System.out.println("notfound");
                                flag = false;
                                return "not found";
                            }
                        }
                    }
                }
            }
        }

        if (!flag) {
            return "not found";
        }
        return matched.toString();
    }
}