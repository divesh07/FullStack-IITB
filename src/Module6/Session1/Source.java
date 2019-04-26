public class Source{
    public static void main(String[] a){

        //Create two objects of Square class 's1' and 's2'
        Square s1 = new Square();
        Square s2 = new Square();

        //Calculate and print their areas after assigning values to their side lengths
        s1.length = 10f;
        s2.length = 20f;
        System.out.println(s1.area());
        System.out.println(s2.area());
    }
}

class Square{
    public float length;
    public float area(){
        return length * length;
    }
}