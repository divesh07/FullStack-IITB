package graded;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        b.setB();
    }
}

class A{
    protected int a;
    public A(){
        System.out.println("A constructor");
    }
    public void setA(){
        int a = 10;
    }
}

class B extends A{
    public B(){
        super();
        System.out.println("B Constructor");
    }

   public void setB(){
        super.a = 20;
        super.setA();
       System.out.println(a);
   }
}
