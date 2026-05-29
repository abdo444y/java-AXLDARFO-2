package axldarfo;


import java.util.ArrayList;
import java.util.List;

/**
 * ============================================================
 *  AXL Darfo - Main Application
 *  Stage: Darfo Boario Terme, Brescia, Italia
 *
 *  Classes used (10 total):
 *   1. Color        - Manages RGB colors
 *   2. Person       - Base class for people
 *   3. Employee     - Company employee (extends Person)
 *   4. Product      - Product with color, price, stock
 *   5. Order        - Customer purchase order
 *   6. Warehouse    - Product inventory manager
 *   7. Department   - Company department with employees
 *   8. Report       - Report generator
 *   9. Logger       - Application logger
 *  10. App (this)   - Main application entry point
 * ============================================================
 */
public class App {

    private static final Logger logger = new Logger("App");

    public static void main(String[] args) {

        logger.info("Starting AXL Darfo Application...");
        System.out.println();

        // ── 1. COLORS ──────────────────────────────────────────
        logger.info("Initializing colors...");

        Color red    = new Color(220, 50,  50,  "AXL Red");
        Color navy   = new Color(30,  60,  114, "AXL Navy");
        Color silver = new Color(192, 192, 192, "AXL Silver");
        Color gold   = new Color(212, 175, 55,  "AXL Gold");

        logger.logColor(red);
        logger.logColor(navy);
        logger.logColor(silver);
        logger.logColor(gold);

        System.out.println("  Mixed color: " + red.mix(navy));
        System.out.println("  Navy is dark: " + navy.isDark());
        System.out.println("  Gold HEX: " + gold.toHex());
        System.out.println();

        // ── 2. EMPLOYEES ───────────────────────────────────────
        logger.info("Creating employees...");

        Employee emp1 = new Employee("Marco",    "Rossi",    35, "marco@axldarfo.it",   "E001", "IT",    2800.00);
        Employee emp2 = new Employee("Giulia",   "Ferrari",  28, "giulia@axldarfo.it",  "E002", "Sales", 2400.00);
        Employee emp3 = new Employee("Lorenzo",  "Bianchi",  42, "lorenzo@axldarfo.it", "E003", "IT",    3200.00);
        Employee emp4 = new Employee("Sofia",    "Conti",    31, "sofia@axldarfo.it",   "E004", "Sales", 2600.00);

        emp1.setFavoriteColor(navy);
        emp2.setFavoriteColor(gold);

        emp3.giveRaise(10); // 10% raise for Lorenzo
        logger.success("Lorenzo got a 10% raise! New salary: " + emp3.getSalary() + "€");

        // ── 3. DEPARTMENTS ─────────────────────────────────────
        logger.info("Setting up departments...");

        Department itDept    = new Department("Information Technology", navy);
        Department salesDept = new Department("Sales & Marketing",      gold);

        itDept.setManager(emp3);
        itDept.addEmployee(emp1);

        salesDept.setManager(emp2);
        salesDept.addEmployee(emp4);

        System.out.println();
        itDept.printSummary();
        salesDept.printSummary();

        // ── 4. PRODUCTS ────────────────────────────────────────
        logger.info("Adding products to inventory...");

        Product laptop  = new Product("P001", "Laptop Pro 15",     1299.99, 25, silver);
        Product monitor = new Product("P002", "Monitor 27\" 4K",    449.99, 40, Color.BLACK);
        Product keyboard= new Product("P003", "Mechanical Keyboard", 89.99, 100, Color.WHITE);
        Product mouse   = new Product("P004", "Wireless Mouse",      39.99, 150, red);

        // ── 5. WAREHOUSE ───────────────────────────────────────
        logger.info("Setting up warehouse...");

        Warehouse warehouse = new Warehouse("AXL Main Warehouse", "Darfo Boario Terme, BS");
        warehouse.addProduct(laptop);
        warehouse.addProduct(monitor);
        warehouse.addProduct(keyboard);
        warehouse.addProduct(mouse);

        // Find products by color
        List<Product> silverProducts = warehouse.findByColor(silver);
        System.out.println("\nSilver products: " + silverProducts.size());

        // ── 6. ORDERS ──────────────────────────────────────────
        logger.info("Processing orders...");

        Order order1 = new Order("ORD-001", "Cliente: Comune di Darfo");
        Order order2 = new Order("ORD-002", "Cliente: Scuola Media Darfo");

        order1.addProduct(laptop,   2);
        order1.addProduct(monitor,  2);
        order1.confirm();
        order1.ship();

        order2.addProduct(keyboard, 30);
        order2.addProduct(mouse,    30);
        order2.confirm();

        logger.success("Orders processed: " + order1);
        logger.success("Orders processed: " + order2);

        // ── 7. REPORTS ─────────────────────────────────────────
        logger.info("Generating reports...");

        Report report = new Report("Weekly Operations Summary", emp3.getFullName());

        // Warehouse report
        report.generateWarehouseReport(warehouse);

        // Order report
        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        report.generateOrderReport(orders);

        // Color palette report
        List<Color> palette = new ArrayList<>();
        palette.add(red); palette.add(navy);
        palette.add(silver); palette.add(gold);
        palette.add(Color.GREEN); palette.add(Color.BLACK);
        report.generateColorReport(palette);

        // ── DONE ───────────────────────────────────────────────
        logger.success("AXL Darfo Application completed successfully!");
        System.out.println("\n  Stage completed - AXL Darfo, Darfo Boario Terme, Italia");
    }
}
