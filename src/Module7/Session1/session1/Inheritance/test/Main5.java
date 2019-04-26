package session1.Inheritance.test;


class Coffee
{
    private int i;
    protected  int j;
    public int k;
    protected void order()
    {
        System.out.println("Coffee");
    }
}

class Cappuccino extends Coffee
{
    public Cappuccino() {
        super.j = 10;
    }

    public static void main(String args[])
    {
        Cappuccino c = new Cappuccino();
        c.order();

    }
}

public class Main5{
    public static void main(String[] args) {
        Coffee obj = new Coffee();
        obj.j = 10;
        obj.k = 20;

    }



}
