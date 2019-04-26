import java.util.Iterator;
import java.util.PriorityQueue;

import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.Scanner;

class SmallestElement{

    public static void PQimplement(int[] arr, int M){

        // It creates a priority queue and inserts all array elements
        // into the priority queue.
        PriorityQueue<Integer> priorqueue = new PriorityQueue<>();
        for (int x : arr){
            //Write the code here to add element in priority queue
            priorqueue.add (new Integer (x)) ;
        }

        //Write the code here to print smallest element
        System.out.println(priorqueue.peek()) ;
        while (M-- > 0){

            //Write the code here to print top M elements which are going to be removed.
            System.out.println(priorqueue.poll()) ;
        }
        //int size= priorqueue.size();
        Iterator itr=priorqueue.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());
    }


    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int arr[] = getArrayInput(N, scanner);
        PQimplement(arr, M);
    }
}