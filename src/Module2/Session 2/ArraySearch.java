import java.util.Scanner;

public class ArraySearch {
    public static void main(String args[]) {

        int[] array = {10, 20, 30, 40, 50, 60, 71, 80, 90, 91, 23, 33, 36, 48, 12, 9, 54, 68, 77, 26};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the number you wish to check in the array  ");
        int input = scan.nextInt();
        boolean found = false;
        for(int i = 0; i <  array.length; i++) {
            if(array[i]==input)
            { System.out.println("The number is at index  " + i + " of the array");
                found = true;
                break;
            }
        }

        if(found==false){
            System.out.println("Number " + input + " not found in the array");
        }
    }
}
