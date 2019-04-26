package Collections.list;

import java.util.*;

public class Shipment implements Iterable<Product>{

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    private static final int PRODUCT_NOT_PRESENT = -1;
    private final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts;
    private List<Product> heavytVanProducts;

    public void add(Product product){
        products.add(product);
    }

    public void replace(Product oldProduct , Product newProduct){
        // index = -1 if the product is not in the List
        final int index = products.indexOf(oldProduct);
        if ( index != PRODUCT_NOT_PRESENT)
            products.set(index,newProduct);
    }

    public int findSplitPoint(){
        for (int i = 0; i< products.size() ; i++){
            if (products.get(i).getWeight() > LIGHT_VAN_MAX_WEIGHT)
                return i;
        }
        return 0;
    }

    public void prepare(){
        // sort list of products by weight
        products.sort(Product.WeightComparator);

        // find the product index that needs the heavy van
        int splitPoint = findSplitPoint();

        // assign views of the product list for heavy and light vans
        lightVanProducts = products.subList(0,splitPoint);
        heavytVanProducts = products.subList(splitPoint,products.size());
    }

    public List<Product> getHeavyVanProducts(){
        return heavytVanProducts;
    }

    public List<Product> getLightVanProducts(){
        return lightVanProducts;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
