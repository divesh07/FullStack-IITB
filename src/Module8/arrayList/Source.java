package arrayList;

import java.util.ArrayList;                  //ArrayList library imported

class Source {
    public static void main(String[] args) {

        //Declare and create an object of the ArrayList class named 'random', in place of the line above
        ArrayList<Float> random = new ArrayList<Float>();
        random.add(2.0f);
        random.add(4.0f);
        random.add(5.0f);
        random.add(10.0f);
        random.add(99.9f);

        if ( random.contains(10f)){
            final int index = random.indexOf(10f);
            random.remove(10f);
            random.add(index,15.0f);
        }
        printArray(random);
    }


    public static void printArray(ArrayList<Float> arr) {
        for(Float f : arr) {
            System.out.println(f);
        }
    }
}
