package model;

import java.io.*;

public class Data implements Serializable {
    private String id;
    private String name;
    private String course;
    private String klass;
    private String garde;

    public Data(String id, String name, String course, String klass, String garde) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.klass = klass;
        this.garde = garde;
    }

    // Copy constructor
    public Data(Data data) {
        this.id = data.id;
        this.name = data.name;
        this.course = data.course;
        this.klass = data.klass;
        this.garde = data.garde;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getKlass() {
        return klass;
    }

    public String getGarde() {
        return garde;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setKlass(String klass) {
        this.klass = klass;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }

    public Data read(String name) {
        Data data = null;

        try (FileInputStream file = new FileInputStream(name)) {
            try (ObjectInputStream object = new ObjectInputStream(file)) {
                data = (Data) object.readObject();
            }
        } catch (IOException | ClassNotFoundException exception) {
            System.out.println(exception.getMessage());
        }

        return data;
    }

    public void write(String name) {
        try (FileOutputStream file = new FileOutputStream(name)) {
            try (ObjectOutputStream object = new ObjectOutputStream(file)) {
                object.writeObject(this);
                object.flush();
            }
        } catch (IOException exception) {
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
        return String.format("ID: %s | Name: %s | Course: %s | Classroom: %s, Grade: %s",
                this.id, this.name, this.course, this.klass, this.garde);
    }
}
