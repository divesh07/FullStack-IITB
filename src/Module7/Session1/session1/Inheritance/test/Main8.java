package session1.Inheritance.test;

public class Main8 {
    public static void main(String[] args) {
        Student s1 = new ArtsStudent();
        //Person1 p1 = new Person1();
        //ArtsStudent a1 = new Student();
        //Employee e1 = new Student();


    }
}

abstract class Person1 {

}

class Employee extends Person1 {

}

class Student extends Person1 {

}

class ArtsStudent extends Student {


}