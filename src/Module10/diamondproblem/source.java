package diamondproblem;

public class source {
    public static void main(String[] args) {
        D obj = new D();
        A a = obj;
        a.doSomething();

        B b = obj;
        b.doSomething();

        C c = obj;
        c.doSomething();

        obj.doSomething();
    }
}

interface A{
    void doSomething();
}

interface B extends A{
    @Override
    void doSomething();
}

interface C extends A{
    @Override
    void doSomething();
}

class D implements B,C{
    @Override
    public void doSomething() {
        System.out.println("Implementing both B and C");
    }
}