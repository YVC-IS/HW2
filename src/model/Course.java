package model;

import java.util.HashSet;
import java.util.Set;

public class Course {
    private final int id;
    private final String name;
    private final int capacity;
    private static final Set<Course> courses = new HashSet<>();

    public Course(String name, int capacity) {
        this.id = Course.courses.size() + 1;
        this.name = name;
        this.capacity = capacity;
        Course.courses.add(this);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    @Override
    public String toString() {
        return String.format("Course { id: %d | name: %s | capacity: %d }", this.id, this.name, this.capacity);
    }
}
