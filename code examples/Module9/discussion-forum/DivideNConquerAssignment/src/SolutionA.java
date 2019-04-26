import java.util.Scanner;

public class SolutionA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Get the size of the array
        int size = scan.nextInt();
        // Array is one indexed
        int[] arr = new int[size + 1];
        // Flag to check if the element is found or not found
        boolean invalid = false;

        // Get Elements
        for (int i = 1; i < size + 1; i++) {
            // Check the first element to be either zero or greater
            if (i == 1) {
                int x = scan.nextInt();
                if (x >= 0) {
                    arr[i] = x;
                } else {
                    System.out.println("Invalid Input !! First element needs to be 0 or greater than 0");
                    invalid = true;
                    break;
                }
            } else {
                // Check for elements to be in ascending order
                int x = scan.nextInt();
                // Compare current element with previous , so that ascending order is maintained
                if (x > arr[i - 1]) {
                    arr[i] = x;
                } else {
                    System.out.println("Invalid Input !! Element needs to be in ascending order and no duplicates allowed");
                    invalid = true;
                    break;
                }
            }
        }
        if (!invalid) {
            // Call the binary searh function for the run time to be o(logn)
            search(arr);
        }
    }

    /**
     * @param arr - Input array and prints the smallest M where A[M] = M
     */
    public static void search(int[] arr) {
        // start with index 1 as the array is One indexed and not zero
        int start = 1;
        int end = arr.length - 1;
        // Create another array which stores all A[M] = M but we need to return the smallest M
        int[] match = new int[arr.length];
        int count = 0;
        int index = 0;

        boolean found = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid == arr[mid]) {
                found = true;
                match[count] = mid;
                count++;
                index = mid;
                // search for a smaller index if any
                end = mid - 1;
            } else if (mid < arr[mid]) {
                // index is smaller hence the number would be to left
                end = mid - 1;
            } else {
                // index is greater hence the mid number would be to right
                start = mid + 1;
            }
        }
        if (found == true) {
            System.out.println(arr[index]);
        } else {
            System.out.println("NOT_FOUND");
        }
    }
}
