package axldarfo;

/**
 * Color Class - Manages RGB colors for AXL Darfo Application
 * Stage: AXL Darfo, Darfo Boario Terme, Italia
 */
public class Color {

    // Predefined colors
    public static final Color RED    = new Color(255, 0,   0,   "Red");
    public static final Color GREEN  = new Color(0,   255, 0,   "Green");
    public static final Color BLUE   = new Color(0,   0,   255, "Blue");
    public static final Color YELLOW = new Color(255, 255, 0,   "Yellow");
    public static final Color WHITE  = new Color(255, 255, 255, "White");
    public static final Color BLACK  = new Color(0,   0,   0,   "Black");
    public static final Color ORANGE = new Color(255, 165, 0,   "Orange");
    public static final Color PURPLE = new Color(128, 0,   128, "Purple");

    private int red;
    private int green;
    private int blue;
    private String name;

    // Constructor with name
    public Color(int red, int green, int blue, String name) {
        setRed(red);
        setGreen(green);
        setBlue(blue);
        this.name = name;
    }

    // Constructor without name
    public Color(int red, int green, int blue) {
        this(red, green, blue, "Custom");
    }

    // Getters
    public int getRed()    { return red; }
    public int getGreen()  { return green; }
    public int getBlue()   { return blue; }
    public String getName(){ return name; }

    // Setters with validation (0-255)
    public void setRed(int red) {
        if (red < 0 || red > 255) throw new IllegalArgumentException("Red must be 0-255, got: " + red);
        this.red = red;
    }
    public void setGreen(int green) {
        if (green < 0 || green > 255) throw new IllegalArgumentException("Green must be 0-255, got: " + green);
        this.green = green;
    }
    public void setBlue(int blue) {
        if (blue < 0 || blue > 255) throw new IllegalArgumentException("Blue must be 0-255, got: " + blue);
        this.blue = blue;
    }
    public void setName(String name) { this.name = name; }

    // Convert to HEX string e.g. "#FF0000"
    public String toHex() {
        return String.format("#%02X%02X%02X", red, green, blue);
    }

    // Mix this color with another color
    public Color mix(Color other) {
        int r = (this.red   + other.red)   / 2;
        int g = (this.green + other.green) / 2;
        int b = (this.blue  + other.blue)  / 2;
        return new Color(r, g, b, "Mixed");
    }

    // Check if color is dark (brightness < 128)
    public boolean isDark() {
        double brightness = (red * 0.299 + green * 0.587 + blue * 0.114);
        return brightness < 128;
    }

    @Override
    public String toString() {
        return String.format("Color[%s | R:%d G:%d B:%d | %s]", name, red, green, blue, toHex());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Color)) return false;
        Color other = (Color) obj;
        return this.red == other.red && this.green == other.green && this.blue == other.blue;
    }
}
