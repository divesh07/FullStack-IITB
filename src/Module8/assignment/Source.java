package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

class Source{
    public static void main(String[] args) {
        Institute ca = new Institute("Christ Academy");
        Student s11 = new Student("Vigyan", ca);
        Student s12 = new Student("Vedanshi", ca);
        Student s13 = new Student("Jahnvi", ca);
        Student s14 = new Student("Abhiraj", ca);
        Student[] ca_students = { s11, s12, s13, s14 };
        ca.addStudent(ca_students);

        Institute vibgyor = new Institute("VIBGYOR");
        Student s21 = new Student("Sai", vibgyor);
        Student s22 = new Student("Pragati", vibgyor);
        Student s23 = new Student("Mukil", vibgyor);
        Student[] vibgyor_students = { s21, s22, s23 };
        vibgyor.addStudent(vibgyor_students);

        System.out.println(ca);
        System.out.println(vibgyor);
    }
}

class Institute{
    private final String name;
    private final List<Student> students = new ArrayList<Student>();
    public int numberOfStudents = 1;

    public Institute(String name) {
        // complete this constructor

        // Instruction:
        // Set the instance variable name to the parameter variable name
        this.name = name;
    }

    public void addStudent(Student s) {
        // complete this method here

        // Instruction:
        // add student s to the instance variable: ArrayList<Student> students
        students.add(s);
    }

    public void addStudent(Student[] array) {
        // complete this method here

        // instruction:
        // add all the students in the Student[] array to
        // the instance variable: ArrayList<Student> students
        students.addAll(Arrays.asList(array));
    }

    public String toString() {
        // complete this method

        // Instruction:
        // 1. Loop through all the students stored in the instance variable: ArrayList<Student> students and return a String that contains the each name and roll number of each student
        // 2. An example String to be returned should look like:
        //    "Christ Academy: Vigyan 1, Vedanshi 2, Jahnvi 3, Abhiraj 4, "// notice the extra comma and space at the end
        String str = "";
        str +=  this.name + ": ";
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            str += it.next() + ", ";
        }
        return str;
    }

}

class Student {
    private final String name;
    private final int rollNumber;
    private final Institute institute;

    public Student(String n, Institute institute) {
        this.name = n;
        this.institute = institute;
        this.rollNumber = this.institute.numberOfStudents++;
    }

    public String toString() {
        return this.name + " " + this.rollNumber;
    }
}
