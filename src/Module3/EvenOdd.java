import java.util.Scanner;

public class EvenOdd {

    public static void main(String[] args ) {
        // test even / odd
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        if(a%2 == 0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }

        int[] numbers = {1,2,3,45,7,78,9};
        if(numbers[4] % 2 ==0){
            System.out.println("even");
        }else{
            System.out.println("odd");
        }





    }
}
