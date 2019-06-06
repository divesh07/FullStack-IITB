import static java.lang.Math.abs;

/**
 *  Calculator class which takes in 2 integers and perform operations
 */
public class Calculator {

    private double first;
    private double second;

    public Calculator(double first, double second) {
        this.first = first;
        this.second = second;
    }

    public double Addition(double first, double second) {
        return first + second;
    }

    public double Subtract(double first, double second) {
        return abs(first - second);
    }

    public double Multiple(double first, double second) {
        return first * second;
    }

    public double Divide(double first, double second) throws Exception {
        if (second > 0) {
            return first / second;
        }
        throw new Exception("Illegal second argument");
    }
}