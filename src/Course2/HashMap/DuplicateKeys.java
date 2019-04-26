import java.util.Hashtable;

public class DuplicateKeys {
    public static void main(String[] args) {
        Hashtable<Integer,String> boardingPass= new Hashtable<Integer,String>();
        int arr[]={20,17,28,15,24,22,17,21,34};

        for(int i:arr)
        {
            //Check whether the pass already exists in the hash table or not.
            // If it doesn’t, add it to the table; otherwise, print the duplicate pass number.
            if ( boardingPass.containsKey(i)){
                System.out.println(i);
            }else{
                boardingPass.put(i, "Checked");
            }
        }
    }
}
