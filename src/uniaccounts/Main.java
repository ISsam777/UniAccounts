package uniaccounts;

import java.util.Arrays;
import uniaccounts.audit.AuditLogger;
import uniaccounts.builders.StudentAccountBuilder;
import uniaccounts.models.StudentAccount;
import uniaccounts.prototype.AccountTemplate;
import uniaccounts.repository.AccountRepository;

public class Main {
    public static void main(String[] args) {
        AccountRepository repository = AccountRepository.getInstance();
        AuditLogger audit = AuditLogger.getInstance();

        // Builder: create a student with required and selected optional fields.
        StudentAccount ahmed = new StudentAccountBuilder(
                "2026001", "Ahmed Benali", "ahmed@gmail.com")
                .phone("0550123456")
                .level("L2")
                .major("Computer Science")
                .scholarship(true)
                .courses("Java", "Database", "Operating Systems")
                .build();

        repository.addAccount(ahmed);
        audit.log("Created account for " + ahmed.getFullName()
                + " (ID: " + ahmed.getId() + ")");

        // Prototype: prepare a template for students in the same batch.
        StudentAccount batchTemplate = new StudentAccountBuilder(
                "TEMPLATE", "Template Student", "template@univ.dz")
                .level("L1")
                .major("Mathematics")
                .courses(Arrays.asList("Calculus", "Algebra", "Programming"))
                .build();

        AccountTemplate prototype = new AccountTemplate(batchTemplate);

        StudentAccount sara = prototype.createAccount(
                "2026002", "Sara Ouali", "sara@gmail.com");
        StudentAccount youssef = prototype.createAccount(
                "2026003", "Youssef Ali", "youssef@gmail.com");

        repository.addAccount(sara);
        audit.log("Created account for " + sara.getFullName()
                + " (ID: " + sara.getId() + ")");

        repository.addAccount(youssef);
        audit.log("Created account for " + youssef.getFullName()
                + " (ID: " + youssef.getId() + ")");

        System.out.println("\\n--- All student accounts ---");
        for (StudentAccount account : repository.getAllAccounts()) {
            System.out.println(account);
        }

        System.out.println("\\nTotal accounts: " + repository.size());
        System.out.println("Audit entries: " + audit.getEntries().size());

        // Demonstrate Singleton: both references point to the same instance.
        System.out.println("Same repository instance: "
                + (repository == AccountRepository.getInstance()));
        System.out.println("Same audit logger instance: "
                + (audit == AuditLogger.getInstance()));
    }
}
