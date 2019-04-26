public class AreaProcedural{

    public static float radius = 10.0f;
    public static float length = 20.0f;
    public static void main(String[] a){
        System.out.println("area of circle = " + Circle.area(radius));
        System.out.println(Circle.circumference(2 * radius));
        System.out.println("area of square = " + Square1.area(length));
    }
}

class Circle{
    public static float pi = 3.141f;
    public static float area(float radius){
        return pi * radius * radius;
    }

    public static float circumference(float diamter){
        return pi * diamter;
    }
}

class Square1{
    public static float area(float length){
        return length * length;
    }
}
