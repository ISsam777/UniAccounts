package uniaccounts.builders;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import uniaccounts.models.StudentAccount;

// Builder: constructs StudentAccount without a long constructor call.
public class StudentAccountBuilder {
    private String id;
    private String fullName;
    private String email;
    private String phone = null;
    private String level = "L1";
    private String major = null;
    private boolean scholarship = false;
    private List<String> courses = new ArrayList<>();

    public StudentAccountBuilder(String id, String fullName, String email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
    }

    public StudentAccountBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }

    public StudentAccountBuilder level(String level) {
        this.level = level;
        return this;
    }

    public StudentAccountBuilder major(String major) {
        this.major = major;
        return this;
    }

    public StudentAccountBuilder scholarship(boolean scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public StudentAccountBuilder courses(List<String> courses) {
        this.courses = new ArrayList<>(courses);
        return this;
    }

    public StudentAccountBuilder courses(String... courses) {
        this.courses = new ArrayList<>(Arrays.asList(courses));
        return this;
    }

    public StudentAccount build() {
        if (id == null || id.isBlank())
            throw new IllegalArgumentException("Student ID is required.");
        if (fullName == null || fullName.isBlank())
            throw new IllegalArgumentException("Full name is required.");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("A valid email containing @ is required.");

        List<String> allowedLevels = Arrays.asList("L1", "L2", "L3", "M1", "M2");
        if (!allowedLevels.contains(level))
            throw new IllegalArgumentException("Level must be L1, L2, L3, M1 or M2.");

        return new StudentAccount(id, fullName, email, phone, level,
                                  major, scholarship, courses);
    }
}
