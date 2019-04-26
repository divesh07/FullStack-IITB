package test;

public class Test1{
    public static void main(String[] args) {
        Demo d = new Demo(5);
    }
}

class Demo {
    private int var;

    public Demo(int var) {
        this.var = var;
    }

    private void setVar(int var) {
        this.var = var;
    }
}
