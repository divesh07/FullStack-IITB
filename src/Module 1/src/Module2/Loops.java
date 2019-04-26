package Module2;

public class Loops {
    public static void main(String[] args) {
        // print numbers 1 - 100
        /*int counter = 1;
        while ( counter <= 100){
            System.out.println(counter);
            counter++;
        }*/

        /*int number = 0;
        while(number<=100) {
            System.out.println(number);
            number = number-1;
        }*/

        // Print odd number from 25-1 in decreasing order
        int num = 25;
        while( num > 0 ) {
            if ( num%2 == 1) {
                System.out.print(num + " ");
            }
            // write decrement/increment condition here
            num--;
        }
    }
}
