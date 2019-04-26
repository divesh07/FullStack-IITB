package MultiDArray;

public class Three3DArray {
    public static void main(String[] args) {
        int[][][] arr= new int[2][2][3];
        for ( int i = 0 ; i< arr.length;i++){
            for ( int j = 0; j < arr[i].length; j++){
                for ( int k = 0 ; k < arr[i][j].length ; k++ ){
                    arr[i][j][k] = k;
                    System.out.print(arr[i][j][k] + " ");
                }
                System.out.println(" ");
            }
            System.out.println(" ");
        }
    }
}
