package Collections.list;

import java.util.Comparator;

public class Product implements Comparable<Product>{
    private String name;
    private final int weight;

    public Product(String name , int weight){
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.getWeight() - o.getWeight();
    }

    public static Comparator<Product> WeightComparator = new Comparator<Product>() {
        @Override
        public int compare(Product e1, Product e2) {
            return (int) (e1.getWeight() - e2.getWeight());
        }
    };

}
