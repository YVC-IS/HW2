package model;

import com.opencsv.bean.CsvBindByName;

import java.util.Date;

public abstract class Person {
    @CsvBindByName
    private final int id;

    @CsvBindByName
    private final String name;

    @CsvBindByName
    private final Date birthdate;

    @CsvBindByName
    private final String username;

    @CsvBindByName
    private final String password;

    public Person(int id, String name, Date birthdate, String username, String password) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.username = username;
        this.password = password;
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

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return String.format("id: %d | name: %s | birthdate: %s", this.id, this.name, this.birthdate);
    }
}
