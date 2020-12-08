package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Student extends Person {
    private static final Set<Student> students = new HashSet<>();

    public Student(String name, Date birthdate) {
        super(Student.students.size() + 1, name, birthdate);
        Student.students.add(this);
    }




    @Override
    public String toString() {
        return String.format("Student { %s }", super.toString());
    }
}
