package Collections.set;

import Collections.list.Product;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ProductCatalog implements Iterable<Product>{

    private final Set<Product> setProducts = new HashSet<>();

    public void isSuppliedBy(Supplier<Product> supplier){
        setProducts.addAll(supplier.getProducts());
    }

    @Override
    public Iterator<Product> iterator() {
        return setProducts.iterator();
    }
}
