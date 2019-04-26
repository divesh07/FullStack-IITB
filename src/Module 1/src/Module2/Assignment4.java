package Module2;

public class Assignment4 {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 5, 6, 7, 2, 9, 10, 10} ;

        for (int i = 0; i < numbers.length; i++){
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    System.out.println(numbers[i]);
                }
            }
        }
    }
}
