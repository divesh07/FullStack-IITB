package session1.Inheritance.test;

public class Main4 {
    public static void main(String[] args) {

        superclass A = new superclass();
        superclass B = new subclass();
        A.print();
        B.print();

    }


    public static class superclass
    {
        void print()
        {
            System.out.println("superclass.");
        }
    }

    public static class subclass extends superclass
    {

        void print()
        {
            System.out.println("subclass.");
        }
    }
}
