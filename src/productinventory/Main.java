package productinventory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("Product Inventory");
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. List Products");
            System.out.println("4. Search by Name");
            System.out.println("5. Search by Category");
            System.out.println("6. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity in stock: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    Product newProduct = new Product(name, category, price, quantity);
                    inventory.addProduct(newProduct);
                    System.out.println("Product added successfully!");
                    break;

                case 2:
                    System.out.print("Enter product name to remove: ");
                    String removeName = scanner.nextLine();
                    List<Product> productsToRemove = inventory.searchByName(removeName);
                    if (!productsToRemove.isEmpty()) {
                        // Assuming user wants to remove the first matching product found.
                        Product productToRemove = productsToRemove.get(0);
                        inventory.removeProduct(productToRemove);
                        System.out.println("Product removed successfully!");
                    } else {
                        System.out.println("Product not found in the inventory.");
                    }
                    break;

                case 3:
                    List<Product> productList = inventory.listProducts();
                    System.out.println("Product List:");
                    for (int i = 0; i < productList.size(); i++) {
                        System.out.println((i + 1) + ". " + productList.get(i));
                    }
                    break;

                case 4:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    List<Product> foundByName = inventory.searchByName(searchName);
                    if (!foundByName.isEmpty()) {
                        System.out.println("Found the following products by name:");
                        for (Product product : foundByName) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found by name.");
                    }
                    break;

                case 5:
                    System.out.print("Enter product category to search: ");
                    String searchCategory = scanner.nextLine();
                    List<Product> foundByCategory = inventory.searchByCategory(searchCategory);
                    if (!foundByCategory.isEmpty()) {
                        System.out.println("Found the following products by category:");
                        for (Product product : foundByCategory) {
                            System.out.println(product);
                        }
                    } else {
                        System.out.println("No products found by category.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting the program.");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
