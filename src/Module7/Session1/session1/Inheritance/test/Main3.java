package session1.Inheritance.test;

public class Main3 {

}


class Calculate {



    public void compute(int num) {

        System.out.println("Square of the number is = " +(num*num));

    }

}


class Polymorphism extends Calculate {

    @Override
    public void compute(int num) {
        super.compute(num);
        System.out.println("Square root of the number is = " + Math.sqrt(num));
    }

    void compute(int num, float sum) {
        System.out.println("Square root of the number is = " + Math.sqrt(num));
    }

}