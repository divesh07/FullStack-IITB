public class Student {
    private final String name;
    private static int year; // made static
    private static final int annualFees = 10000;

    public Student (String name, int year) {
        this.name = name;
        this.year= year;
    }
    public String getDetails() {
        return "Name : " + name;
    }
    public int computeFees( ) {
        return this.annualFees * Student.year ;
    }

    public static void main(String[] args) {
        Student s1 = new Student("ankit",2018);
        System.out.println("student name = " + s1.getDetails());
        System.out.println("computed fee = " + s1.computeFees());
    }
}

class ResearchStudent {
    private final String name;
    private static int year;
    private static final int annualFees = 10000;
    String researchArea;

    public ResearchStudent (String name, int year, String researchArea) {
        this.name = name;
        this.year= year;
        this.researchArea = researchArea;
    }

    public String getDetails() {
        return "Name : " + name;
    }

    public int computeFees( ) {
        return this.annualFees * ResearchStudent.year ;
    }
}

class Main{
    public static void main(String[] args) {
        
    }
}