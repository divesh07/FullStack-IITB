package arrayList;
import java.util.ArrayList;

public class WithArray {
    public static void main(String[] args) {
        Student studenList[] = {
                new Student("Karan", 1),
                new Student("Deepika",2),
                new Student("Arjun",3)
        };
        printStudent(studenList);

        ArrayList studentList = new ArrayList();
        /*studentList.add(new Student("Karan", 1));
        studentList.add(new Student("Deepika", 2));
        studentList.add(new Student("Arjun", 3));
        */

        studentList.add(new Student("Sujit", 1));
        studentList.add(new Student("Siddharth", 2));
        studentList.add(new Student("Karanpreet", 3));
        studentList.add(4,new Student("Hari", 4));
        studentList.add(3, new Student("Tricha", 5));

        printStudentArray(studentList);



    }
    public static void printStudentArray( ArrayList students){
        for (Object o:students){
            Student s = (Student) o;
            System.out.println(s.getDetails());
        }
    }

    public static void printStudent(Student[] students){
        for(Student s : students){
            System.out.println(s.getDetails());
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
