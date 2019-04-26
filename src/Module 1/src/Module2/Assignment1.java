package Module2;

public class Assignment1 {
    public static void main(String[] args) {
        //prints the numbers between 2,000 and 3,000, which are divisible by 8 but not by 6.
        int i;
        for ( i = 2000 ; i <=3000 ; i++) {
            if ( (i%8 ==0) && (i%6 !=0)) {
                System.out.print(i + " ");
            }
        }
    }
}
