package List;

import java.util.*;

public class WithArray {
    public static void main(String[] args) {
        // List is an interface that is implemented by the ArrayList and LinkedList class
        //The List interface extends the Collection interface
        // AbstractList implements the List interface
        AbstractList<Student> studentList1 = new LinkedList<Student>();
        List<Student> studentList2 = new ArrayList<Student>();
        Collection<Student> studentList3 = new ArrayList<Student>();

        Student s1 = new Student("Sujit", 1);
        Student s2 = new Student("Siddharth", 2);
        Student s3 = new Student("Karanpreet", 3);
        Student s4 = new Student("Hari", 4);
        Student s5 = new Student("Tricha", 5);

        studentList1.add(s1);studentList1.add(s2);studentList1.add(s3);
        studentList2.add(s4);
        studentList3.add(s5);

        printStudentArray(studentList1);
        printStudentArray(studentList2);
        printColllection(studentList3);

        listIteratorFwd(studentList1);
        listIteratorBck(studentList1);
        listIteratorBothWays(studentList1);
    }

    public static void printStudentArray( List<Student> students){
        for (Student s:students){
            System.out.println(s.getDetails());
        }
    }

    public static void printColllection( Collection<Student> students){
        for (Student s:students){
            System.out.println(s.getDetails());
        }
    }

    public static void listIteratorFwd(List<Student> students){
        ListIterator<Student> it = students.listIterator();
        while(it.hasNext()){
            System.out.println(it.next().getDetails());
        }
    }

    public static void listIteratorBck(List<Student> students){
        ListIterator<Student> it = students.listIterator(students.size()); // points beyond last eleement
        while(it.hasPrevious()){
            System.out.println(it.previous().getDetails());
        }
    }

    public static void listIteratorBothWays(List<Student> students){
        ListIterator<Student> it = students.listIterator();
        System.out.println("Print fwd");
        while(it.hasNext()){
            System.out.println(it.next().getDetails());
        }
        System.out.println("Print back");
        while(it.hasPrevious()){
            System.out.println(it.previous().getDetails());
        }
    }



}

class Student {
    private final String  name;
    private final int  rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public String getDetails(){
        return "name = " + name + " rollno = " + rollNo;
    }
}
