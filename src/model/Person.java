package model;

import java.util.Date;

public abstract class Person {
    private final int id;
    private final String name;
    private final Date birthdate;

    public Person(int id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Date getBirthdate() {
        return this.birthdate;
    }

    @Override
    public String toString() {
        return String.format("id: %d | name: %s | birthdate: %s", this.id, this.name, this.birthdate);
    }

}
