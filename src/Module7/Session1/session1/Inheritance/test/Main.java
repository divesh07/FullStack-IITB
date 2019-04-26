package session1.Inheritance.test;

public class Main {
    public static void main(String[] args) {
        Policeman police = new Policeman("Shiva", 40, "brown");
        police.display();
    }
}

class Person {
    protected String eyeColor;
    protected String name;

    public Person(String name, String eyeColor) {
        this.name = name;
        this.eyeColor = eyeColor;
    }
}

class Adult extends Person {
    protected int age;

    public Adult(String name, int age, String eyeColor) {
        super(name,eyeColor);
        this.age = age;
    }
}

class Policeman extends Adult {
    protected final String job;

    public Policeman(String name, int age, String eyeColor) {
        super(name, age, eyeColor);
        this.job = "policeman";
    }

    public void display(){
        System.out.println("name = " + name + "age = " + age + "job = " + job + " eyeColor" + super.eyeColor);
    }

}