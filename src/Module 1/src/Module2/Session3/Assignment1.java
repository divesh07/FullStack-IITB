package Module2.Session3;

public class Assignment1 {
    public static void main(String[] args) {
        //1) a multiple of three, it prints ‘Fizz’ (instead of the number).
        //2) a multiple of five, it prints ‘Buzz’ (instead of the number).
        //3) a multiple of both three and five, it prints ‘FizzBuzz’ (instead of the number).
        //4) otherwise, it simply prints the number.

        int[] numbers = {1,2,34,5,6,7,8,9,10,11,12,13,14,15};
        fizzBuzz(numbers);
    }

    public static void fizzBuzz(int[] numbers) {
        //Write the function body here
        for (int i = 0 ; i < numbers.length; i++){
            //System.out.println(numbers[i]);
            if ( ( numbers[i] % 3 == 0 ) && (numbers[i] % 5 ==0) ){
                System.out.print("FizzBuzz ");
            } else if (numbers[i] % 3 == 0){
                System.out.print("Fizz ");
            } else if (numbers[i] % 5 == 0){
                System.out.print("Buzz ");
            } else {
                System.out.print(numbers[i] + " ");
            }
        }

    }
}
