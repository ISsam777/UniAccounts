package uniaccounts.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import uniaccounts.models.StudentAccount;

// Singleton: one shared repository for all student accounts.
public class AccountRepository {
    private static final AccountRepository INSTANCE = new AccountRepository();
    private final Map<String, StudentAccount> accounts = new LinkedHashMap<>();

    private AccountRepository() {}

    public static AccountRepository getInstance() {
        return INSTANCE;
    }

    public void addAccount(StudentAccount account) {
        if (account == null)
            throw new IllegalArgumentException("Account cannot be null.");
        if (accounts.containsKey(account.getId()))
            throw new IllegalArgumentException("ID already exists: " + account.getId());

        accounts.put(account.getId(), account);
        System.out.println("Account added: " + account.getId());
    }

    public StudentAccount findById(String id) {
        return accounts.get(id);
    }

    public Collection<StudentAccount> getAllAccounts() {
        return Collections.unmodifiableCollection(accounts.values());
    }

    public int size() {
        return accounts.size();
    }
}
