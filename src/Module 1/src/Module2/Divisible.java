package Module2;

public class Divisible {
    public static void main(String[] args) {
        //print even numbers divisible by 7, between 1 and 1000
        int number = 1;
        do{
            if ( (number%2 == 0) && (number%7 == 0) ){
                System.out.print(number + " ");
            }
            number++;
        }while(number<=1000);



    }
}
