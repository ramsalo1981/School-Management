package se.lex.dao;

import se.lex.model.Course;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoList implements CourseDao{
    private static final List<Course> courses = new ArrayList<>();

    @Override
    public Course saveCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Cannot save a null course.");
        }
        courses.add(course);
        return course;
    }

    @Override
    public Course findById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    @Override
    public List<Course> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Course name cannot be null.");
        }
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public List<Course> findByDate(LocalDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        List<Course> result = new ArrayList<>();
        for (Course course : courses) {
            if (course.getStartDate().equals(date)) {
                result.add(course);
            }
        }
        return result;
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

    @Override
    public boolean removeCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Cannot remove a null course.");
        }
        return courses.remove(course);
    }
}
