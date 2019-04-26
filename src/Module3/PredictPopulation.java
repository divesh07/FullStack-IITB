public class PredictPopulation {
    public static void main(String[] args) {
        // Predict
        // Current population = 102349
        // increases = 15% every year

        double current = 102349;
        double hike  = ((double)15/100 )  * current;
        System.out.println(hike);
        int finalResult = (int) (hike + current);
        System.out.println(finalResult);

    }
}
