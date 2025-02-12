package se.lex.model;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Course  {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String courseName;
    private LocalDate startDate;
    private int weekDuration;
    private List<Student> students;

    public Course( String courseName, LocalDate startDate, int weekDuration) {
        this.id = count.incrementAndGet();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.students = new ArrayList<>();
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public LocalDate getStartDate() { return startDate; }
    public int getWeekDuration() { return weekDuration; }
    public List<Student> getStudents() { return students; }

    // Register a student
    public void register(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    // Unregister a student
    public void unregister(Student student) {
        students.remove(student);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, startDate, weekDuration, students);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                '}';
    }
}
