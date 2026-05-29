package axldarfo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Logger Class - Simple logging utility for AXL Darfo application
 */
public class Logger {

    public enum Level { INFO, WARNING, ERROR, SUCCESS }

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private String componentName;
    private boolean verbose;

    public Logger(String componentName) {
        this.componentName = componentName;
        this.verbose       = true;
    }

    public Logger(String componentName, boolean verbose) {
        this.componentName = componentName;
        this.verbose       = verbose;
    }

    // Core log method
    public void log(Level level, String message) {
        if (!verbose && level == Level.INFO) return;
        String time = LocalDateTime.now().format(FORMATTER);
        String tag  = switch (level) {
            case INFO    -> "[INFO]   ";
            case WARNING -> "[WARN]   ";
            case ERROR   -> "[ERROR]  ";
            case SUCCESS -> "[OK]     ";
        };
        System.out.printf("%s %s [%s] %s%n", time, tag, componentName, message);
    }

    // Convenience methods
    public void info(String msg)    { log(Level.INFO,    msg); }
    public void warn(String msg)    { log(Level.WARNING, msg); }
    public void error(String msg)   { log(Level.ERROR,   msg); }
    public void success(String msg) { log(Level.SUCCESS, msg); }

    // Log with color info
    public void logColor(Color color) {
        info("Color loaded: " + color);
    }

    public void setVerbose(boolean verbose) { this.verbose = verbose; }
    public boolean isVerbose()              { return verbose; }
}
