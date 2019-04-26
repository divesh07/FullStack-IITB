package sorting;

import java.util.*;

public class JavaObjectSorting {
    public static void main(String[] args) {
        //sorting primitive array
        int[] intArr = {5,9,1,10};
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        //sorting String Array
        String[] strArr = {"A","C","B","Z","E"};
        Arrays.sort(strArr);
        System.out.println(Arrays.toString(strArr));

        //sorting list of objects of Wrapper classes
        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("C");
        strList.add("B");
        strList.add("Z");
        strList.add("E");
        Collections.sort(strList);
        System.out.println(strList);

        List<Employee> empList = new ArrayList<>();
        Employee emp1 = new Employee(10,"Mickey", 25,10000);
        Employee emp2 = new Employee(20, "Arun", 29, 20000);
        Employee emp3 = new Employee(5, "Lisa", 35, 5000);
        Employee emp4 =  new Employee(1, "Pankaj", 32, 50000);
        //Collections.sort(empList); // nedd to implemenet Comparable interface to use this
        //System.out.println(empList);

        Employee[] empArr = new Employee[4];
        empArr[0] = new Employee(10, "Mikey", 25, 10000);
        empArr[1] = new Employee(20, "Arun", 29, 20000);
        empArr[2] = new Employee(5, "Lisa", 35, 5000);
        empArr[3] = new Employee(1, "Pankaj", 32, 50000);
        Arrays.sort(empArr); // java.lang.ClassCastException: sorting.Employee cannot be cast to java.lang.Comparable
        // sort employee using Comparable by Id
        System.out.println(Arrays.toString(empArr));

        //sort employees array using Comparator by Salary
        Arrays.sort(empArr,Employee.SalaryComparator);
        System.out.println(Arrays.toString(empArr));

        //sort employees array using Comparator by Age
        Arrays.sort(empArr,Employee.AgeComparator);
        System.out.println(Arrays.toString(empArr));

    }
}


class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private int age;
    private long salary;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getSalary() {
        return salary;
    }

    public Employee(int id, String name, int age, long salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // Comparator annpnymous class
    //Comparator to sort employees list or array in order of Salary
    public static Comparator<Employee> SalaryComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return (int)(o1.getSalary() - o2.getSalary());
        }
    };

    //Comparator to sort employees list or array in order of Age
    public static Comparator<Employee> AgeComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getAge() - o2.getAge();
        }
    };

    @Override
    //this is overridden to print the user-friendly information about the Employee
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee emp) {
        //let's sort the employee based on an id in ascending order
        //returns a negative integer, zero, or a positive integer as this employee id
        //is less than, equal to, or greater than the specified object.
        return this.id - emp.id;
    }

}
