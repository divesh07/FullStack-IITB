package heaps;

import java.util.Scanner;

class CheckArrForHeaps {
    public static boolean isHeap(int[] arr, int n) {
        //Write your code here
        //Check if the array element is less than it's child element in the array,
        //and if they are less return false else return true
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // Checking for left child
            if (arr[i] < arr[2 * i + 1]) {
                return false;
            }
            // Checking for right child
            if (2 * i + 2 < n && arr[i] < arr[2 * i + 2]) {
                return false;
            }
        }
        return true;
    }

    public static int[] getArrayInput(int size, Scanner scanner) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sizeArray1 = scanner.nextInt();
        int arr[] = getArrayInput(sizeArray1, scanner);
        int n = arr.length;
        String x = isHeap(arr, n) ? "YES" : "NO";

        System.out.println(x);
    }

}

