package Module2;

public class MinIn2DArray {
    public static void main(String[] args) {

        int array[][] = {{34,23,39,26,49},{92,89,78,21,24}, {50,60,55,67,70},{62,65,70,70,81},{72,66,77,80,69}};
        int rowSize = 5;
        int columnSize = 5;

        // print min
        int min = array[0][0];
        for ( int i = 0 ; i < rowSize ; i++){
            for ( int j = 0 ; j < columnSize; j++){
                if ( min > array[i][j]) {
                    min = array[i][j];
                }
            }
        }
        System.out.println(min);
    }
}
