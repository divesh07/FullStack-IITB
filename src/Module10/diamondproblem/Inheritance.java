package diamondproblem;

public class Inheritance {
    public static void main(String[] args) {
        ProfessorWarden pw = new ProfessorWarden("SKC");
        IProfessor prof = pw;
        IWarden warden = pw;
        prof.teach("OOP", "Upgrad");
        warden.approve("Festive request");

        pw.teach("OOP", "Upgrad");
        pw.approve("Party request");
        pw.doWork();
    }
}

class Person{
    protected final String name;

    public Person(String n) {
        this.name = n;
    }
}

interface IProfessor {
    void teach(String course, String place);
}

interface IWarden {
    void approve(String request);
}

class Professor extends Person implements IProfessor{
    public Professor(String n){
        super(n);

    }
    @Override
    public void teach(String course, String student){
        System.out.println("Prof. " + this.name + "teaches " + course + "to" + student);
    }
}


class Warden extends Person implements IWarden{
    public Warden(String n) {
        super(n);
    }
    @Override
    public void approve(String request){
        System.out.println("warden" + this.name + " approves request " + request);
    }
}

class ProfessorWarden extends Person implements IProfessor, IWarden{
    public ProfessorWarden(String n) {
        super(n);
    }
    public void doWork(){
        System.out.println("working .. ");
    }

    @Override
    public void teach(String course, String place) {
        System.out.println("Prof. " + this.name + "teaches " + course + "to" + place);
    }

    @Override
    public void approve(String request) {
        System.out.println("warden" + this.name + " approves request " + request);
    }
}