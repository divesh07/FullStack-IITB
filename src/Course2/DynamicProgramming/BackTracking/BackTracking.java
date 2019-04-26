package BackTracking;

import java.util.Arrays;

public class BackTracking {

    public static void main(String[] args) {
        //int amount = 13;
        int amount = 1291;
        //int[] d = {1,7,10};
        int[] d = {1,2,5,8,10,14};
        pay(d,amount);
    }

    public static void pay(int[] d, int amount) {
        // First column only prints i , i.e ammount to pay , hence j = length + 1
        int[][] matrix = new int[amount + 1][d.length+1];

        // if ammount = 0 , we dont need to pay anything
        for ( int j = 0 ; j<= d.length ; j++){
            matrix[0][j] = 0;
        }

        // if you are supposed to use the first coin only then you have to give so many coins, as first coin has value 1
        for ( int i = 0; i<= amount; i++){
            matrix[i][0] = i; // prints the ammount to pay
            //matrix[i][1] = i; // since denomination is 1 , matrix[i][1] = i;
        }

        //  pick min((i,d[j-1]) and 1 + min(i-d,d[j]) , Also later should also meet i>=d[j]
        // compute matrix
        for ( int j=1 ; j <= d.length; j++){
            for ( int i = 1 ; i<=amount; i++){

                // use algo
                if ( i >= d[j-1] && matrix[i][j-1] > matrix[i-d[j-1]][j] + 1){
                    matrix[i][j] = 1 + matrix[i-d[j-1]][j];
                }else{
                    matrix[i][j] = matrix[i][j-1];
                }
            }
        }
        System.out.println("Min coins used are : " + matrix[amount][d.length]);
        printMatrix(matrix);

        // Use backtracking to figure out which coins were used:
        // start from (n,k)
        int i = amount;
        int j = d.length;
        while(j > 0 && i > 0){
            if (matrix[i][j] == matrix[i][j-1]){
                // not used the jth coin
                j = j-1;
            }else{
                System.out.println("Picked coin " + d[j-1]);
                i = i -d[j-1];
            }
        }
        while(i> 0){
            System.out.println("Picked coin " + d[0]);
            i = i-1;
        }
    }






    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++)
                System.out.print(matrix[i][j]);
            System.out.print('\n');
        }
    }
}
