import java.util.HashSet;

public class LocksAndKeys {
    //Given an array of locks and an array of keys corresponding to Locks.
    // All the Locks are different, and all keys are also different
    public static void main(String[] args) {
        String keys[] = {"#", "%", "!", "@", "$"};
        String locks[] =  {"!", "@", "#", "$", "%"};
        // Approach 1 - Use 2 arrays O(n2)
        for (String key: keys){
            for (String lock: locks){
                if (key.equalsIgnoreCase(lock)){
                    System.out.println(key + " " + lock);
                }
            }
        }
    }
}
