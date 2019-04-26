package LinearSearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchElement {

    // search the position of an element
    // in the array in the reverse order, returning 0 when the element is not found.

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int count = input.nextInt();
        int[] array = new int[count+1];
        array[0] = 0;
        for (int i = 1; i <= count; i++) {
            array[i] = input.nextInt();
        }
        int key = input.nextInt();
        input.close();
        System.out.println(searchElement(key,array));
    }

    public static int searchElement(int key, int[] array){
        for ( int i = array.length-1; i > 0 ; i--){
            if ( key == array[i]){
                return array.length-i;
            }
        }
        return 0;
    }
}
