package Model;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
    private final int id;
    private final int capacity;
    private static final Set<Classroom> classrooms = new HashSet<>();

    public Classroom(int capacity) {
        this.id = classrooms.size() + 1;
        this.capacity = capacity;
        classrooms.add(this);
    }

    @Override
    public String toString() {
        return String.format("Classroom { id: %d | capacity: %d }", this.id, this.capacity);
    }
}
