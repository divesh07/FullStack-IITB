package linkedList;


import java.util.LinkedList;

class Source {
    public static void main(String[] args) {
        LinkedList<Float> random = new LinkedList<Float>();
        random.add(2f);
        random.add(4f);
        random.add(5f);
        random.add(10f);
        random.add(99f);
        System.out.println(random.get(2));
    }
}
