package Module2;

public class Continue {
    public static void main(String[] args) {
        /*for (int i = 1; i <= 12; i++) {
            if(i > 4 && i < 8){
                continue;
            }
            System.out.println(i);
        }*/

       /* for (int i = 1; i <= 12; i++) {
            if (i == 5){
                break;
            }
            else if(i>8 && i<11){
                continue;
            }
            System.out.println(i);
        }*/

        for (int i = 1; i <= 12; i++) {
            System.out.println(i);

            if(i > 4 && i < 8) {
                continue;
            }
            else if (i == 5) {
                break;
            }
        }
    }
}
