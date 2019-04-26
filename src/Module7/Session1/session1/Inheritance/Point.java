package session1.Inheritance;

public class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Rectangle1 {
    private Point upperleft;
    private Point lowerRight;

    public Rectangle1(Point upperleft, Point lowerRight) {
        this.upperleft = upperleft;
        this.lowerRight = lowerRight;
    }
}
