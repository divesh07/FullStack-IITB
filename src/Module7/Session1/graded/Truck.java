package graded;


abstract class Vehicle {
    private char vehicleType;
    public abstract void move ();
}

public class Truck extends Vehicle {
    private int truckNo;

    @Override
    public void move() {

    }

    public static void main(String args[]) {
        Truck mahindra= new Truck();
        mahindra.move();
    }
}