import java.util.HashSet;
import java.util.Scanner;

public class LocksandKeys3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // get the number of keys
        int n = in.nextInt();

        if (n < 1) {
            System.out.println("Not possible");
            return;
        }

        char keys[] = new char[n];
        char locks[] = new char[n];

        // store all the keys to the array "keys"
        for (int i = 0; i < n; i++) {
            keys[i] = in.next(".").charAt(0);
        }
        in.nextLine();

        //store all the locks to the array "locks"
        for (int i = 0; i < n; i++) {
            locks[i] = in.next(".").charAt(0);
        }

        HashSet<Character> set = new HashSet<>();
        boolean notFound = false;

        for (Character lock : locks) {
            set.add(lock);
        }

        for (Character key : keys) {
            if (set.contains(key)) {
                //System.out.println(key + " " + key);
            } else {
                notFound = true;
            }
        }

        if (notFound) {
            System.out.println("Not possible");
        } else {
            for (Character key : keys) {
                System.out.println(key + " " + key);
            }
        }
    }
}
