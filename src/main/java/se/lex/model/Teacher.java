package se.lex.model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Teacher {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;

    public Teacher( String name) {
        this.id = count.incrementAndGet();
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(name, teacher.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
