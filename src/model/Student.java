package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
    private static final Set<Student> students = new HashSet<>();

    public Student(int id, String name, Date birthdate, String username, String password) {
        super(id, name, birthdate, username, password);
        students.add(this);
    }

    public Student(String name, Date birthdate, String username, String password) {
        this(students.size() + 1, name, birthdate, username, password);
    }

    @Override
    public String toString() {
        return String.format("Student { %s }", super.toString());
    }
}
