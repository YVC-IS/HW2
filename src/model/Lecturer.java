package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Lecturer extends Person {
    private final int seniority;
    private static final Set<Lecturer> lecturers = new HashSet<>();

    public Lecturer(String name, Date birthdate, int seniority) {
        super(lecturers.size() + 1, name, birthdate);
        this.seniority = seniority;
        lecturers.add(this);
    }

    @Override
    public String toString() {
        return String.format("Lecturer { %s | seniority: %d }", super.toString(), this.seniority);
    }
}
