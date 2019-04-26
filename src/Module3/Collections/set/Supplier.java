package Collections.set;

import Collections.list.Product;

import java.util.List;

public class Supplier<P> {

    private String name;

    public static List<Product> products;

    public Supplier(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts(){
        return products;
    }

    public void addProducts(Product product){
        products.add(product);
    }

    @Override
    public String toString() {
        return "Supplier{" +
                "name='" + name + '\'' +
                '}';
    }
}
