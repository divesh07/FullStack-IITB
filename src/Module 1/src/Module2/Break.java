package Module2;

public class Break {
    public static void main(String[] args) {
        /*for (int number = 1; number <= 100; number++) {
            System.out.println(number);
            break;
        }*/

        for (int number = 1; number < 100; number++) {
            if(number==2){
                break;
            } else {
                System.out.println(number);
            }
        }
        for (int number = 100; number <= 200; number++) {
            System.out.print(number + " ");
        }
    }
}
