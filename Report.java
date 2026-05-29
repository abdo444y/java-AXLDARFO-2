package axldarfo;

import java.time.LocalDate;
import java.util.List;

/**
 * Report Class - Generates reports for AXL Darfo management
 */
public class Report {

    private String    title;
    private LocalDate date;
    private String    author;

    public Report(String title, String author) {
        this.title  = title;
        this.author = author;
        this.date   = LocalDate.now();
    }

    // Print a separator line
    private void line(int length) {
        System.out.println("=".repeat(length));
    }

    // Print header block
    private void printHeader() {
        line(60);
        System.out.println("  REPORT: " + title.toUpperCase());
        System.out.println("  Date:   " + date);
        System.out.println("  Author: " + author);
        System.out.println("  Company: AXL Darfo - Darfo Boario Terme, Italia");
        line(60);
    }

    // Generate warehouse report
    public void generateWarehouseReport(Warehouse warehouse) {
        printHeader();
        warehouse.printInventory();
        line(60);
    }

    // Generate department report
    public void generateDepartmentReport(Department department) {
        printHeader();
        department.printSummary();
        line(60);
    }

    // Generate order report
    public void generateOrderReport(List<Order> orders) {
        printHeader();
        System.out.println("\n  ORDER SUMMARY:");
        double grandTotal = 0;
        for (Order o : orders) {
            System.out.println("  " + o);
            grandTotal += o.getTotal();
        }
        System.out.printf("%n  Grand Total: %.2f€%n", grandTotal);
        line(60);
    }

    // Generate color palette report
    public void generateColorReport(List<Color> colors) {
        printHeader();
        System.out.println("\n  COLOR PALETTE:");
        for (Color c : colors) {
            System.out.println("  " + c + (c.isDark() ? " [DARK]" : " [LIGHT]"));
        }
        line(60);
    }

    // Getters
    public String    getTitle()  { return title; }
    public LocalDate getDate()   { return date; }
    public String    getAuthor() { return author; }
}
