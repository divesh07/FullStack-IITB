package Collections.set;

import Collections.list.Product;

public class ProductFixtures {
    public static Product door =  new Product("Wooden Door" , 35);
    public static Product floorPanel = new Product("Floor Panel", 25);
    public static Product window = new Product("Glass Window", 10);

    public static Supplier<Product> bobs = new Supplier<Product>("Bobs Household Supply");
    public static Supplier<Product> kates = new Supplier<Product>("Kate's Homes Goods");

    static {
        bobs.products.add(door);
        kates.products.add(floorPanel);
    }
}
