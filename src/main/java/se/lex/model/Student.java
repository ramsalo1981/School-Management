package se.lex.model;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Student {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String name;
    private String email;
    private String address;
    private List<Course> courses ;


    public Student( String name, String email, String address) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.email = email;
        this.address = address;
        this.courses  = new ArrayList<>();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.register(this);
        }
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            courses.remove(course);
            course.unregister(this); // Bidirectional relationship
        }
    }


    public List<Course> getCourses() { return courses; }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(email, student.email) && Objects.equals(address, student.address) && Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, address, courses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", courses=" + courses +
                '}';
    }
}
