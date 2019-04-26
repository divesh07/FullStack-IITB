public class Test {

}

abstract class Shape {
    protected int length;
    protected int breadth;

    Shape(int length , int breadth){
        this.length = length;
        this.breadth = breadth;
    }

    abstract void getArea();

    abstract void getPerimeter();

    void printShape() {
        System.out.println("Shape super class");
    }

}

class Square extends Shape{

    public Square(int length , int breadth){
        super(length,breadth);
    }

    @Override
    void getArea() {
        System.out.println("area = " + length * length);
    }

    @Override
    void getPerimeter() {
        System.out.println("perimeter = " + 4 * length);
    }
}

