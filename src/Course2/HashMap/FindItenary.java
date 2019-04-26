import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FindItenary {
    //given the source and destination of all the tickets in the form of a map,
    // and you have to print the itinerary
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // get the no of tickets from input
        int n = in.nextInt();
        if ( n< 1){
            return;
        }
        // map to store all the tickets
        Map<String, String> tickets = new HashMap<String, String>();

        // Store the source and destination of the tickets to the map "tickets"
        for (int i = 0; i < n; i++) {
            String source = in.next();
            String dest = in.next();
            if ( tickets.containsKey(source)){
                if(tickets.get(source).compareTo(dest) >= 0){
                }else{
                    tickets.put(source, dest);
                }
            }else {
                tickets.put(source, dest);
            }
            in.nextLine();
        }

        // write your code here
        Map<String, String> reverse = new HashMap<String, String>();
        for( String s : tickets.keySet()){
            reverse.put(tickets.get(s), s);
        }

        String source = null;
        for (String s : tickets.keySet()){
            if (!reverse.containsKey(s)){
                source = s;
                System.out.print(s + " ");
            }
        }
        while(source !=null){
            if ( tickets.containsKey(source)) {
                source = tickets.get(source);
                System.out.print(source + " ");
            }else{
                break;
            }
        }
    }
}
