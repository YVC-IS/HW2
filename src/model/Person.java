package model;

import com.opencsv.bean.CsvBindByName;

import java.io.*;
import java.util.Date;

public abstract class Person implements Serializable {
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

    public Person read() {
        Person person = null;

        try (FileInputStream file = new FileInputStream("person.ser")) {
            try (ObjectInputStream object = new ObjectInputStream(file)) {
                person = (Person) object.readObject();
            }
        }
        catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return person;
    }

    public void write() {
        try (FileOutputStream file = new FileOutputStream("person.ser")) {
            try (ObjectOutputStream object = new ObjectOutputStream(file)) {
                object.writeObject(this);
                object.flush();
            }
        }
        catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Serial
    private void readObject(ObjectInputStream stream) throws ClassNotFoundException, IOException {
        stream.defaultReadObject();
    }

    @Serial
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
    }

    @Override
    public String toString() {
        return String.format("id: %d | name: %s | birthdate: %s", this.id, this.name, this.birthdate);
    }
}
