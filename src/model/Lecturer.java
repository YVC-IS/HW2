package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Lecturer extends Person {
    private final int seniority;
    private static final Set<Lecturer> lecturers = new HashSet<>();

    public Lecturer(int id, String name, Date birthdate, String username, String password, int seniority) {
        super(id, name, birthdate, username, password);
        this.seniority = seniority;
        lecturers.add(this);
    }

    public Lecturer(String name, Date birthdate, String username, String password, int seniority) {
        this(lecturers.size() + 1, name, birthdate, username, password, seniority);
    }

    @Override
    public String toString() {
        return String.format("Lecturer { %s | seniority: %d }", super.toString(), this.seniority);
    }
}
