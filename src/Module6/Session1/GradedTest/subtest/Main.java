package GradedTest.subtest;


public class Main {

    public static void main(String[] args) {

        TestClass c1 = new TestClass(2, 5.2);
        TestClass c2 = new TestClass(3, 7.5);
        //System.out.println(c1.a + ", " + c1.b);
    }
}

class TestClass {

    private int a;
    public double b;

    public TestClass(int first, double second) {
        this.a = first;
        this.b = second;
    }
}