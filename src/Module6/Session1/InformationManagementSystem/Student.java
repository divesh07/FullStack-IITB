package InformationManagementSystem;

public class Student {
    private String name;
    private int rollno;
    private double cgpa = 0;

    public Student(int rollno,String name) {
        this.name = name;
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public int getRollno() {
        return rollno;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public void displayProfile() {
        System.out.println(rollno + " " + name + " " + cgpa);
    }

    public double findPercentage() {
        return cgpa * 10;
    }
}


class Main {
    public static void main(String[] args) {
        Student s1 = new Student(1056,"karan");
        s1.displayProfile();
        s1.setCgpa(8.8);
        System.out.println("Percentage of " + s1.getName() + " is " + s1.findPercentage());
    }
}
