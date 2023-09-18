package productinventory;

public class Product {
    // Decalring variables
    private String name;
    private String category;
    private double price;
    private double quantity;

    public Product(String name, String category, double price, double quantity) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return name + " (" + category + ") - $" + price + " - In Stock: " + quantity;
    }

}
