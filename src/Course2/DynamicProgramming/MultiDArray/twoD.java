package MultiDArray;

import java.util.Arrays;
import java.util.Collections;

public class twoD {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];

        for (int i = 0 ; i < 2 ; i++){
            for (int j = 0 ; j < 3 ; j++){
                arr[i][j] = j;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }

}
