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
    private Teacher teacher;
    private List<Lecture> lectures;

    public Course( String courseName, LocalDate startDate, int weekDuration, Teacher teacher) {
        this.id = count.incrementAndGet();
        this.courseName = courseName;
        this.startDate = startDate;
        this.weekDuration = weekDuration;
        this.teacher = teacher;
        this.students = new ArrayList<>();
        this.lectures = new ArrayList<>();
    }

    // Getters & Setters
    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    public LocalDate getStartDate() { return startDate; }
    public int getWeekDuration() { return weekDuration; }
    public Teacher getTeacher() { return teacher; }
    public List<Student> getStudents() { return students; }
    public List<Lecture> getLectures() { return lectures; }

    // Register a student
    public void register(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
        }
    }

    // Unregister a student
    public void unregister(Student student) {
        if (students.contains(student)) {
            students.remove(student);
            student.removeCourse(this);
        }
    }
    public void addLecture(Lecture lecture) {
        if (!lectures.contains(lecture)) {
            lectures.add(lecture);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return weekDuration == course.weekDuration && Objects.equals(courseName, course.courseName) && Objects.equals(startDate, course.startDate) && Objects.equals(students, course.students) && Objects.equals(teacher, course.teacher) && Objects.equals(lectures, course.lectures);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, startDate, weekDuration, students, teacher, lectures);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", startDate=" + startDate +
                ", weekDuration=" + weekDuration +
                ", students=" + students +
                ", teacher=" + teacher +
                ", lectures=" + lectures +
                '}';
    }
}
