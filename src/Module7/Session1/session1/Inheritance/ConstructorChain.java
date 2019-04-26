package session1.Inheritance;

import org.w3c.dom.css.Rect;

class Shape {
    public Shape() {
        super();
        System.out.println("inside Shape class default constructor");
    }
}

class Rectangle extends Shape {
    protected int width;
    private int breadth;
    public Rectangle(int width , int breadth) {
        super();
        System.out.println("inside Rectangle class default constructor");
        this.width = width;
        this.breadth = breadth;
    }
}

class Square extends Rectangle {
    public Square(int length) {
        super(length,length);
        System.out.println("inside Square class default constructor");
        System.out.println(super.width);
    }
}

public class ConstructorChain {
    public static void main(String[] args) {
        Rectangle sq = new Square(10);
    }
}

