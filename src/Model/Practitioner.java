package Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Practitioner extends Person {
    private final String degree;
    private static final Set<Practitioner> practitioners = new HashSet<>();

    public Practitioner(String name, Date birthdate, String degree) {
	    super(practitioners.size() + 1, name, birthdate);
	    this.degree = degree;
	    practitioners.add(this);
    }

    @Override
    public String toString() {
        return String.format("Practitioner { %s | degree: %s }", super.toString(), this.degree);
    }
}
