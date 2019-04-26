package Module2.Session3;

public class Assignment2 {
    public static void main(String[] args) {
        //1) takes in an int array called votesPerUser as a parameter,
        // where each element in the array represents the number of votes received by the user, with the userId at that index.
        //2) returns the index of the user with the most votes.
        //3) if there are ties between users with the most votes,
        // returns the index of the first user with the most votes.
        // For example, if the 0th and 7th users in the array both have 20 votes, and both have the most number of votes, they return 0.

        int[] votes = {1,2,34,5,6,7,8,9,10,11,12,13,14,15};
        int userWithMostVotes = mostVotes(votes);
        System.out.println("User with the most votes is User: " + userWithMostVotes);
    }

    // write the function mostVotes() here.
    public static int mostVotes(int[] votes){
        int maxIndex = 0;
        for ( int i = 0 ; i < votes.length; i++){
             if ( votes[i] > votes[maxIndex] ){
                 maxIndex = i;
             }
        }
        return maxIndex;
    }

}
