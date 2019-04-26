package session1.Inheritance.test;

public class Rectangle {
    private double width;
    private double height;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void area() {
        System.out.println("Area of Rectangle is: " +  (width * height) ) ;
    }

    public void perimeter() {
        System.out.println("Perimeter of Rectangle is: " + ( (2* width) +
                (2* height) ) ) ;
    }
}

class Square extends Rectangle{
    public Square(double width, double height) {
        super(width, height);
    }

    @Override
    public void area() {
        super.area();
    }

    @Override
    public void perimeter() {
        System.out.println("Perimeter of Rectangle is: " + 4 * super.getWidth() ) ;
    }
}

class Main1{
    public static void main(String[] args) {
        Square obj = new Square(10,10);
        obj.area();
        obj.perimeter();
    }
}