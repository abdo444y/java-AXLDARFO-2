package axldarfo;

/**
 * Product Class - Represents a product sold or managed by AXL Darfo
 */
public class Product {

    private String productId;
    private String name;
    private double price;
    private int    stock;
    private Color  color;

    public Product(String productId, String name, double price, int stock, Color color) {
        this.productId = productId;
        this.name      = name;
        setPrice(price);
        setStock(stock);
        this.color = (color != null) ? color : Color.WHITE;
    }

    // Getters
    public String getProductId() { return productId; }
    public String getName()      { return name; }
    public double getPrice()     { return price; }
    public int    getStock()     { return stock; }
    public Color  getColor()     { return color; }

    // Setters
    public void setName(String name)  { this.name = name; }
    public void setColor(Color color) { this.color = color; }
    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
    }
    public void setStock(int stock) {
        if (stock < 0) throw new IllegalArgumentException("Stock cannot be negative.");
        this.stock = stock;
    }

    // Reduce stock by quantity
    public boolean sell(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        if (stock < quantity) {
            System.out.println("Not enough stock for: " + name);
            return false;
        }
        stock -= quantity;
        return true;
    }

    // Restock product
    public void restock(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        stock += quantity;
    }

    public boolean isAvailable() { return stock > 0; }

    @Override
    public String toString() {
        return String.format("Product[ID:%s | %s | %.2f€ | Stock:%d | Color:%s]",
                productId, name, price, stock, color.getName());
    }
}
