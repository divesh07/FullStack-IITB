import java.util.*;

public class ListPolymorphism1 {
  public static void main(String[] args) {
    List<Student> studentList1 = new ArrayList<Student>();
    List<Student> studentList2 = new LinkedList<Student>();

    Student s1 = new Student("Sujit",1);
    Student s2 = new Student("Siddharth",2);
    Student s3 = new Student("Karanpreet",3);
    Student s4 = new Student("Hari",5);
    Student s5 = new Student("Tricha",4);

    studentList1.add(s1);
    studentList1.add(s2);
    studentList1.add(s3);

    studentList2.add(s4);
    studentList2.add(s5);

    printStudentList(studentList1);
    printStudentList(studentList2);


  }

  public static void printStudentList(List<Student> students) {
    System.out.println("Printing student details.....");
    for(Student s : students) {
      System.out.println(s.getDetails());
    }
  }
}

class Student {
  private final String name;
  private final int rollNumber;

  public Student(String name, int rollNumber) {
    this.name = name;
    this.rollNumber = rollNumber;
  }

  public String getDetails() {
    return
      "name = " + this.name + '\n' +
      "roll number = " + this.rollNumber + '\n';
  }
}

/*
  SUMMARY
  =======

  printStudents as a polymorphic function. It uses List (which is a super-class of ArrayList and List) 
    instead of ArrayList or List, thus inter-operates smoothly with both types.
*/
