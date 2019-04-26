package session1;

abstract class SuperClass{
    private int a;
    private int b;
    public SuperClass(){
        System.out.println("This is super class default constructor");
        a =0;
        b =0;
    }

    public SuperClass(int a, int b) {
        this.a = a;
        this.b = b;
        System.out.println("This is super class parameterized constructor");
    }

    abstract int add (int a , int b);
}
public class AbstractHelper extends SuperClass{

    public AbstractHelper(){
        super(1,2);
        System.out.println("THis is sub class constructor");
    }
    @Override
    int add(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {
        AbstractHelper obj = new AbstractHelper();
        System.out.println(obj.add(1,2));
    }
}



