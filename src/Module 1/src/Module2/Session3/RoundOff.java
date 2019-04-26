package Module2.Session3;

public class RoundOff {
    // given an array of decimal numbers. You are required to round these into integers
    public static void main(String[] args) {
        double[] array = {10.32,20.36,30.50,40.51,50.49,60.43,71.71};

        for(int i = 0; i <  array.length; i++) {
            // Write the round function here.
            array[i] = Math.round(array[i]);
        }


        for(int i = 0; i <  array.length; i++) {
            System.out.print(array[i] + " ");
        }

    }

}
