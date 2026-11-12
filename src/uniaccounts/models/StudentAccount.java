package uniaccounts.models;

import java.util.ArrayList;
import java.util.List;

public class StudentAccount implements Cloneable {
    private String id;
    private String fullName;
    private String email;
    private String phone;
    private String level;
    private String major;
    private boolean scholarship;
    private List<String> courses;

    public StudentAccount(String id, String fullName, String email,
                          String phone, String level, String major,
                          boolean scholarship, List<String> courses) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.level = level;
        this.major = major;
        this.scholarship = scholarship;
        this.courses = new ArrayList<>(courses);
    }

    // Prototype: clone an account template, including an independent courses list.
    @Override
    public StudentAccount clone() {
        return new StudentAccount(id, fullName, email, phone, level,
                                  major, scholarship, courses);
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getLevel() { return level; }
    public String getMajor() { return major; }
    public boolean hasScholarship() { return scholarship; }
    public List<String> getCourses() { return new ArrayList<>(courses); }

    public void setId(String id) { this.id = id; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setLevel(String level) { this.level = level; }
    public void setMajor(String major) { this.major = major; }
    public void setScholarship(boolean scholarship) { this.scholarship = scholarship; }
    public void setCourses(List<String> courses) {
        this.courses = new ArrayList<>(courses);
    }

    @Override
    public String toString() {
        return "StudentAccount{" +
                "id='" + id + "'" +
                ", fullName='" + fullName + "'" +
                ", email='" + email + "'" +
                ", phone='" + phone + "'" +
                ", level='" + level + "'" +
                ", major='" + major + "'" +
                ", scholarship=" + scholarship +
                ", courses=" + courses +
                '}';
    }
}
