package uniaccounts.prototype;

import uniaccounts.models.StudentAccount;

// Prototype: creates accounts by cloning a prepared batch template.
public class AccountTemplate {
    private final StudentAccount template;

    public AccountTemplate(StudentAccount template) {
        if (template == null)
            throw new IllegalArgumentException("Template cannot be null.");
        this.template = template.clone();
    }

    public StudentAccount createAccount(String id, String fullName, String email) {
        StudentAccount copy = template.clone();
        copy.setId(id);
        copy.setFullName(fullName);
        copy.setEmail(email);
        return copy;
    }
}
