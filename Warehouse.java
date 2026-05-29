package axldarfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Warehouse Class - Manages the product inventory at AXL Darfo
 */
public class Warehouse {

    private String       name;
    private String       location;
    private List<Product> inventory;

    public Warehouse(String name, String location) {
        this.name      = name;
        this.location  = location;
        this.inventory = new ArrayList<>();
    }

    // Getters
    public String getName()     { return name; }
    public String getLocation() { return location; }

    // Add product to warehouse
    public void addProduct(Product product) {
        if (product == null) throw new IllegalArgumentException("Product cannot be null.");
        inventory.add(product);
        System.out.println("Added to warehouse: " + product.getName());
    }

    // Remove product by ID
    public boolean removeProduct(String productId) {
        for (Product p : inventory) {
            if (p.getProductId().equals(productId)) {
                inventory.remove(p);
                System.out.println("Removed product: " + p.getName());
                return true;
            }
        }
        System.out.println("Product not found: " + productId);
        return false;
    }

    // Find product by ID
    public Product findProduct(String productId) {
        for (Product p : inventory) {
            if (p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    // Find products by color
    public List<Product> findByColor(Color color) {
        List<Product> result = new ArrayList<>();
        for (Product p : inventory) {
            if (p.getColor().equals(color)) result.add(p);
        }
        return result;
    }

    // Get total inventory value
    public double getTotalValue() {
        double total = 0;
        for (Product p : inventory) total += p.getPrice() * p.getStock();
        return total;
    }

    // Print all products
    public void printInventory() {
        System.out.println("\n=== Warehouse: " + name + " (" + location + ") ===");
        if (inventory.isEmpty()) {
            System.out.println("  [Empty warehouse]");
        } else {
            for (Product p : inventory) System.out.println("  " + p);
        }
        System.out.printf("  Total Value: %.2f€%n", getTotalValue());
    }

    public int getProductCount() { return inventory.size(); }
}
