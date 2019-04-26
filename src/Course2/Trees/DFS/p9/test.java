package DFS.p9;

public class test {
    private int x ;

    public test(int x) {
        //this.x = x;
        setX(x);
    }

    public int getX() {
        return x;
    }

    private void setX(int x) {
        if ( x > 0 ){
            this.x = x;
        }
    }

}

class Demo{
    public static void main(String[] args) {
        test t1 = new test(10);

        System.out.println(t1.getX());
    }
}