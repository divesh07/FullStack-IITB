package Collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionConcept {
    public static void main(String[] args) {
        Product door = new Product("Wooden Door" , 35);
        Product floorPanel = new Product("Floor Panel", 25);
        Product window = new Product("Glass Window", 10);

        Collection<Product> products = new ArrayList<>(); // List of type products
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        System.out.println(products);

        // Remove product from collection which is above certain element
        Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()){
            Product product = productIterator.next();
            if (product.getWeight() > 20)
                System.out.println(product);
            else
                productIterator.remove();
        }
        System.out.println(products);
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(door));
        System.out.println(products.contains(window));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(door);
        otherProducts.add(window);

        products.removeAll(otherProducts);
        System.out.println(products);
        products.remove(window);
        products.add(door);
        products.add(window);

        // Same as above , compiler iternally calls Iterator
        // But the for loop cant remove element from the Collections
        for(Product product : products){
            if (product.getWeight()> 20) {
                System.out.println(product);
            } else {
                // Exception in thread "main" java.util.ConcurrentModificationException
                // As we are modifying and looping at same time
                // to remove / add we have to use iterators
                // All of the below 3 lines would cause exceptions
                products.remove(product);
                products.clear();
                products.add(window);
            }
        }


    }
}
