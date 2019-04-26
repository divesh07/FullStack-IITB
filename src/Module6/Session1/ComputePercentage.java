public class ComputePercentage {
    public static void main(String[] args) {
        Student1 s1 = new Student1();
        s1.name = "Ankit";
        s1.cgpa = 8.8;
        // Print statement to be inserted here
        System.out.println(s1.findPercentage());
    }

}

class Student1{
    public String name;
    public double cgpa;
    public double findPercentage() {
        return cgpa * 10;
    }
}
