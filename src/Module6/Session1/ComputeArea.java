public class ComputeArea {
    public static void main(String[] args) {
        Circle1 obj = new Circle1(10.0f);
        //obj.setRadius(10.0f);
        printCircle(obj);
    }

    public static void printCircle(Circle1 c) {
        System.out.println("radius of circle = " + c.getRadius());
        System.out.println("value of PI  = " + Circle1.getPI());
        System.out.println("area of a circle = " + c.area());
    }
}

class Circle1 {
    private float radius;

    private static final float PI = 3.14f;

    public Circle1(float radius) {
        setRadius(radius);
    }

    public float getRadius() {
        return radius;
    }

    public static float getPI() {
        return PI;
    }

    public void setRadius(float radius) {
        if ( radius >= 0f) {
            this.radius = radius;
        }
    }

    private float square(){
        return radius * radius;
    }

    public float area() {
        return PI * square();
    }
}