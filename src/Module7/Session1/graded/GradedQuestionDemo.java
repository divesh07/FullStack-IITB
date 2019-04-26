package graded;


public class GradedQuestionDemo {
    public static void main(String[] args) {
        Square mySquare = new Square(5.0);

        mySquare.myMethod(10);
    }
}

class Rectangle {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void myMethod(int someVariable){
        System.out.println("Rectangle");
    }
}

class Square extends Rectangle {
    public Square(double side) {
        super(side, side);
    }

    public void myMethod(int someVariable){
        super.myMethod(someVariable);
        System.out.println("Square");
    }
}