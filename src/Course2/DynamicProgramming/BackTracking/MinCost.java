package BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class MinCost {
    //Write the code such that given the destination in terms of the x and y coordinates,
    // your code prints the minimum cost to reach the destination.
    //from a given cell (i, j), cells (i + 1, j), (i, j + 1), and (i + 1, j + 1) can be traversed
    // traverse down, right, and diagonally
    public static void main(String[] args) {
        int cost[][] = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt();
        int yCoordinate = scan.nextInt();
        System.out.println(minCost(cost,xCoordinate,yCoordinate));
    }

    private static int minCost(int cost[][], int m, int n)
    {
        int minCost[][]=new int[m+1][n+1];
        /* Initialise the first column of the minimum cost (table) array */
        /* Initialise the first row of the table array */
        /* Construct the rest of the table array from the recursion relation */
        minCost[0][0]=1;
        for ( int j = 1 ; j<= n; j++){
            minCost[0][j] = cost[0][j] + minCost[0][j-1];
        }
        for ( int i = 1 ; i<= m; i++){
            minCost[i][0] = cost[i][0] + minCost[i-1][0];
        }

        for ( int j = 1 ; j<= n; j++){
            for ( int i =1 ; i<=m ; i++){
                minCost[i][j] = cost[i][j] + min(minCost[i-1][j-1],minCost[i-1][j],minCost[i][j-1]);
            }
        }

        //System.out.println(Arrays.deepToString(minCost));
        return minCost[m][n];
    }

    public static int min( int i,int j,int k){
        return Math.min(i,Math.min(j,k));
    }
}
