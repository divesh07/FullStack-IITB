public class MaxPathways {

   // Returns count of possible paths to reach
   // point (m-1, n-1)
   // from the topmost leftmost point (0, 0)
   static int maxNumberOfPaths(int m, int n)
   {
       // Create a 2D matrix to store results
       // of subproblems
       int count[][] = new int[m][n];

       // Calculate count of paths for other
       // cells in bottom-up manner using
       // the recursive solution
       for (int i = 0; i < m; i++)
       {
           for (int j = 0; j < n; j++){
               if (i == 0 || j == 0){
                   // If the cell is in the first row or first column,
                   // then there is only one path to reach it, from top left most cell.
                   count[i][j] = 1;
               }else {
                   count[i][j] = count[i-1][j] + count[i][j-1];
               }
           }
       }
       return count[m-1][n-1];
   }

   // Driver program to test above function
   public static void main(String args[])
   {
       System.out.println(maxNumberOfPaths(3, 3));
       System.out.println(maxNumberOfPaths(3, 2));
       System.out.println(maxNumberOfPaths(4, 4));
       System.out.println(maxNumberOfPaths(4, 5));
       System.out.println(maxNumberOfPaths(10, 8));
   }

}
