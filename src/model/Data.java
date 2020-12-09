package model;

public class Data {

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

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", klass='" + klass + '\'' +
                ", garde='" + garde + '\'' +
                '}';
    }
}
