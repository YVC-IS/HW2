package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Practitioner extends Person {
    private final String degree;
    private static final Set<Practitioner> practitioners = new HashSet<>();

    public Practitioner(int id, String name, Date birthdate, String username, String password, String degree) {
        super(id, name, birthdate, username, password);
        this.degree = degree;
        practitioners.add(this);
    }

    public Practitioner(String name, Date birthdate, String username, String password, String degree) {
        this(practitioners.size() + 1, name, birthdate, username, password, degree);
    }

    @Override
    public String toString() {
        return String.format("Practitioner { %s | degree: %s }", super.toString(), this.degree);
    }
}
