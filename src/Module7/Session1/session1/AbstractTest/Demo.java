package session1.AbstractTest;

public abstract class Demo
{
    public int a;
    Demo()
    {
        a = 10;
    }
    abstract public void set();
    abstract public void get();
}

class Test extends Demo
{
    public void set()
    {
        super.a = 20;
    }

     public void get()
    {
        System.out.println("a = " + a);
    }

    public static void main(String[] args)
    {
        Test obj = new Test();
        obj.set();
        obj.get();
    }
}
