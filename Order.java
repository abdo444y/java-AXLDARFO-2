package axldarfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Order Class - Represents a purchase order
 */
public class Order {

    private String       orderId;
    private String       customerName;
    private List<Product> products;
    private String       status;  // PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED

    public Order(String orderId, String customerName) {
        this.orderId      = orderId;
        this.customerName = customerName;
        this.products     = new ArrayList<>();
        this.status       = "PENDING";
    }

    // Getters
    public String       getOrderId()      { return orderId; }
    public String       getCustomerName() { return customerName; }
    public List<Product> getProducts()   { return products; }
    public String       getStatus()      { return status; }

    // Add a product to the order
    public boolean addProduct(Product product, int quantity) {
        if (product.sell(quantity)) {
            // Add one entry per item for simplicity
            for (int i = 0; i < quantity; i++) products.add(product);
            return true;
        }
        return false;
    }

    // Calculate total price
    public double getTotal() {
        double total = 0;
        for (Product p : products) total += p.getPrice();
        return total;
    }

    // Update status
    public void confirm()  { this.status = "CONFIRMED"; }
    public void ship()     { this.status = "SHIPPED"; }
    public void deliver()  { this.status = "DELIVERED"; }
    public void cancel()   { this.status = "CANCELLED"; }

    @Override
    public String toString() {
        return String.format("Order[ID:%s | Customer:%s | Items:%d | Total:%.2f€ | Status:%s]",
                orderId, customerName, products.size(), getTotal(), status);
    }
}
