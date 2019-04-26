package session1;

public class Main {
    public static void main(String[] args) {
        BankAccount studentAccount = new BankAccount(1234567, 12000);
        Student s1 = new Student("ankit", 2, studentAccount);
        //System.out.println("student details = " + s1.getDetails());
        //System.out.println(s1.computeFees());

        BankAccount researchStudentAccount = new BankAccount(1234568, 15000);
        ResearchStudent s2 = new ResearchStudent("pankaj", 3, researchStudentAccount, "machine learning");
        //s1 = new ResearchStudent("pankaj", 3, researchStudentAccount, "machine learning");
        //System.out.println("research student details = " + s2.getDetails());
        //System.out.println(s1.computeFees(20));

        BankAccount phdStudentAccount = new BankAccount(1234568, 15000);
        PhDStuent s3 = new PhDStuent("deepak", 4, phdStudentAccount, "machine learning", "NLP");
        //System.out.println("research student details = " + s3.getDetails());

        Professor p1 = new Professor("SKP", 10000,3456);
        Person[] arr = {p1,s1,s2};
        printDetails(arr);
    }

    public static void printDetails(Person[] persons){
        for(Person person : persons){
            System.out.println(person.getDetails());
        }
    }
}

abstract class Person {
    protected final String name;

    public Person(String name) {
        this.name = name;
    }

    abstract String getDetails();
}
class Student extends Person{
    private int year; // made static
    private static final int annualFees = 10000;
    private BankAccount bankAccount;

    public Student(String name, int year, BankAccount bankAccount) {
        super(name);
        this.year = year;
        this.bankAccount = bankAccount;
    }

    public String getDetails() {
        return "Name : " + super.name + '\n' + " Fee : " + computeFees();
    }

    public float computeFees() {
        return Student.annualFees * this.year;
    }

    public float computeFees(int fee){
        return fee * this.year;
    }
}

class Professor extends Person{
    private int startingSalary;
    private int employeeNumber;

    public Professor(String name, int startingSalary, int employeeNumber) {
        super(name);
        this.startingSalary = startingSalary;
        this.employeeNumber = employeeNumber;
    }

    @Override
    protected String getDetails() {
        return "Name : " + super.name + '\n' + "empNo : " + employeeNumber + "\nsalary " + startingSalary + "\n";
    }
}

class ResearchStudent extends Student {
    private String researchArea;

    public ResearchStudent(String name, int year, BankAccount bankAccount, String researchArea) {
        super(name, year, bankAccount);
        this.researchArea = researchArea;
    }
    public String getDetails() {
        return super.getDetails() + "research area = " + this.researchArea;
    }

    public void printDetails(){
        System.out.println("Research Student");
    }
}

class PhDStuent extends ResearchStudent{
    private String thesis;
    public PhDStuent(String name, int year, BankAccount bankAccount, String researchArea, String thesis) {
        super(name, year, bankAccount, researchArea);
        this.thesis = thesis;
    }
    public String getDetails() {
        return super.getDetails() + "research area = " + this.thesis;
    }
}

class BankAccount{
    private int accoutNumber;
    private int balance;

    public BankAccount(int accoutNumber, int balance) {
        this.accoutNumber = accoutNumber;
        this.balance = balance;
    }
}