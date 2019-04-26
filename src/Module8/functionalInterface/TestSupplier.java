package functionalInterface;

import java.util.function.Supplier;

public class TestSupplier {
    public static void main(String[] args) {

        Supplier<Person> supplier = ()->{
            return new Person("Varun", 30, "SDET");
        };

        Person p = supplier.get();
        System.out.println(p.getAddress() + " " + p.getName() + " " + p.getAge());
    }
}
