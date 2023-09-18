package productinventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public List<Product> listProducts() {
        return products;
    }

    public List<Product> searchByName(String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}