package BinarySearch;

// implement binary search
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16};
        //binarySearch(arr,13);
        int[] arr2 = {3, 5, 7, 8, 10, 12, 13, 15, 17, 19};
        binarySearch(arr2,1);

    }

    public static int binarySearch(int[] inputArr, int key) {
        int start = 0;
        int end  = inputArr.length -1 ;
        System.out.println(start + " " + end);

        while(start <= end) {
            int mid = start + ((end - start) / 2);
            System.out.println("Middle element" + inputArr[mid] + " key " + key);
            if (key == inputArr[mid]) {
                System.out.println("Key found");
                return key;
            } else if (key > inputArr[mid]) {
                System.out.println("Key is greater than mid element");
                start = mid + 1;
            } else {
                System.out.println("Key is less than mid element");
                end = mid-1 ;
            }
        }
        System.out.println("Key not found");
        return -1;
    }
}
