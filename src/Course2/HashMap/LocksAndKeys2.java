import java.util.HashSet;

public class LocksAndKeys2 {
    public static void main(String[] args) {
        String keys[] = {"#", "%", "!", "@", "$"};
        String locks[] =  {"!", "@", "#", "$", "%"};
        HashSet<String> set = new HashSet<>();
        for(String lock: locks){
            set.add(lock);
        }

        for(String key:keys){
            if ( set.contains(key)){
                System.out.println(key + " " + key);
            }
        }
    }
}
