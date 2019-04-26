package session1.InterfaceTest;

interface Human{
    static void printDetils(){
        System.out.println("I am Human");
    }
}

interface Person {
    String empId = "10";
    public void getDetails(int age, String name, String empId);
}

interface Class1 {
    static void getDetails(){
        System.out.println("test");
    }
}

abstract class Class2 {

    abstract void get();
}

interface Class4 {
}

// Interface can extend multiple interface::
interface Clas3 extends Class1, Class4{
}

// Class can implement multiple interface:
public class Main extends Class2 implements Person, Human {
    @Override
    public void getDetails(int age, String name, String empId) {
        System.out.println("age =" + age + " name = " + name + " empId = " + empId);
    }

    @Override
    void get() {

    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.getDetails(24,"ankit", "20");
    }
}