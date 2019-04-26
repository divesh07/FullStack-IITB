import java.util.Scanner;

public class SolutionB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // Get the size of the array
        int size = scan.nextInt();
        // Array is one indexed
        int[] arr = new int[size + 1];
        // Flag to check if the element is found or not found
        boolean invalid = false;
        // Get the key whose index needs to be searched
        int searchKey = scan.nextInt();

        // Get Elements
        for (int i = 1; i < size + 1; i++) {
            if (i == 1) {
                // First element should be zero or greater
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
            search(arr, searchKey);
        }
    }

    /**
     * @param arr       - Input array and prints the index of the searchKey
     * @param searchKey - Key whose index needs to be printed
     */
    public static void search(int[] arr, int searchKey) {
        // Array is one indexed hence start pointer should be at index 1
        int start = 1;
        //boolean exception = false;
        // Flag to check if the element is found
        boolean found = false;
        // Counter to count the number of null pointer exceptions caught
        int exceptionCount = 0;
        //boolean exceptionFlagOff = false;
        // End pointer moves at 2x
        int end = 2 * start;

        // While the element isnt found , continue the search
        // Since the end moves at 2x , it can go past the number of elements
        // In that case it would through exception which is caught
        while (!found && exceptionCount <= start) {
            try {
                // If exception is caught , the end pointer is then tried with 2x - exception count
                end = 2 * start - exceptionCount;
                // Function to search for the key in O(logn) time
                found = binarySearch(arr, searchKey, start, end);
                // when all elements are iterated end  2*start - exceptionCount would
                // result in start ==end
                // if the element is still not found would mean element is missing
                // and hence the loop is breaked
                if (start == end) {
                    break;
                }
                // Since all the elements are not iterated yet
                // Start would move to end pointer and end is moved to 2x
                start = end;
            } catch (Exception ignored) {
                //System.out.println("Caught exception , End of array , terminating");
                exceptionCount += 1;
                //exception = true;
            }
        }
        if (!found) {
            System.out.println("NOT_FOUND");
        }
    }

    /**
     * @param arr
     * @param searchKey
     * @param start
     * @param end
     * @return
     */
    public static boolean binarySearch(int[] arr, int searchKey, int start, int end) {
        boolean found = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchKey == arr[mid]) {
                System.out.println(mid);
                return true;
            } else if (searchKey < arr[mid]) {
                // key is smaller hence check left
                end = mid - 1;
            } else {
                // index is greater hence check right
                start = mid + 1;
            }
        }
        return false;
    }
}
