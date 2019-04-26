package Module2;

public class Assignment3 {
    public static void main(String[] args) {
        // find the highest 4-digit prime number.
        for ( int i = 9999 ; i >= 2 ; i--){
            boolean isPrime  = true;
            for ( int j = 2 ; j < Math.sqrt(i) ; j++){
                if ( i%j == 0 ){
                    isPrime = false;
                    break;
                }
            }

            if(isPrime){
                System.out.println(i);
                break;
            }
        }
    }
}
