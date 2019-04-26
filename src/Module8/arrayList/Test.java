package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Test {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("Sujit", 1));
        studentList.add(new Student("Siddharth", 2));
        studentList.add(1, new Student("Karanpreet", 3));
        studentList.add(new Student("Hari", 4));
        studentList.add(1, new Student("Tricha", 5));

        ArrayList<Float> random = new ArrayList<Float>();
        random.add(2f);
        random.add(4f);
        random.add(5f);
        random.add(10f);
        random.add(99.9f);

        System.out.println(random.contains(5.0f));
      }
}
