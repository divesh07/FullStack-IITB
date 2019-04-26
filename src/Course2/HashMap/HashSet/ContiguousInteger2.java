package HashSet;

import java.util.HashSet;
import java.util.Scanner;

public class ContiguousInteger2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();
        if ( n < 1){
            System.out.println(false);
            return;
        }
        //array to store the input elements
        int[] array = new int[n];

        //storing the elements to the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        method(array);
    }

    public static void method(int[]  array ){
        int count = 0,n = array.length;
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for (int i = 0; i < n; i++)
            hashSet.add(array[i]);

        //System.out.println(hashSet);
        int currentElement = array[0];
        // No of distinct element greater or equal to the first number
        while (hashSet.contains(currentElement) == true) {
            count++;
            currentElement--;
        }
        //System.out.println(count);

        currentElement = array[0];
        currentElement++;
        int count2 = 0;

        while (hashSet.contains(currentElement) == true) {
            count2++;
            currentElement++;
        }
        //System.out.println(count2);

        if (count + count2 == hashSet.size()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
