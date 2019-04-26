package Module2;

public class CountIterations {
    public static void main(String[] args) {
        int number = 8;
        int count =0;
        for(int i=1; i<=number; i++){
            for(int j=1; j<=number; j++){
                count++;
                System.out.println(count);
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
