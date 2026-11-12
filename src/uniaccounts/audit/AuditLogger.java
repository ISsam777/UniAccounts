package uniaccounts.audit;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Singleton: one central audit log for the application.
public class AuditLogger {
    private static final AuditLogger INSTANCE = new AuditLogger();
    private final List<String> entries = new ArrayList<>();
    private static final DateTimeFormatter FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private AuditLogger() {}

    public static AuditLogger getInstance() {
        return INSTANCE;
    }

    public void log(String action) {
        String entry = "[" + LocalDateTime.now().format(FORMAT) + "] " + action;
        entries.add(entry);
        System.out.println("AUDIT: " + entry);
    }

    public List<String> getEntries() {
        return Collections.unmodifiableList(entries);
    }
}
