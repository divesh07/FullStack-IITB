abstract class AbstractHelp{
    public int a;

    public AbstractHelp() {
        a = 10;
    }

    abstract public void set(int a);
    abstract public void get();

}

class Main extends AbstractHelp{

    @Override
    public void set(int a ) {
        this.a = a;
    }

    @Override
    public void get() {
        System.out.println(a);
    }

    public static void main(String[] args) {
        Main obj = new Main();
        obj.set(10);
        obj.get();
    }
}