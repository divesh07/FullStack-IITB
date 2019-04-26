public class Search {
    public static void main(String[] args) {
        String[] emails = {"chandler.bing@xyz.com","ross.geller@xyz.com","rachel.greene@xyz.com","joey.tribbiani@xyz.com",
                "monica.geller@xyz.com","phoebe.buffay@xyz.com","sheldon.copper@xyz.com","marie.george@xyz.com"};
        String NewEmail="monica.geller@xyz.com";

        int index = 0;
        boolean found = false;
        for ( String search : emails){
            if (search.equalsIgnoreCase(NewEmail)){
                System.out.println(index);
                found = true;
                break;
            }
            index++;
        }

        if ( !found){
            System.out.println(-1);
        }

    }
}
