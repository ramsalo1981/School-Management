package se.lex.service;

import se.lex.dao.CourseDao;
import se.lex.dao.CourseDaoList;
import se.lex.model.Course;
import se.lex.model.Student;
import se.lex.model.Teacher;

import java.time.LocalDate;
import java.util.List;

public class CourseService {
    private final CourseDao courseDao = new CourseDaoList();

    public void createCourse(String courseName, LocalDate startDate, int weekDuration, Teacher teacher) {
        Course course = new Course( courseName, startDate, weekDuration, teacher);
        courseDao.saveCourse(course);
        System.out.println("Course created!");
    }

    public Course findCourseById(int id) {
        return courseDao.findById(id);
    }

    public List<Course> findCoursesByName(String name) {
        return courseDao.findByName(name);
    }

    public List<Course> findCoursesByDate(LocalDate date) {
        return courseDao.findByDate(date);
    }

    public List<Course> findAllCourses() {
        return courseDao.findAll();
    }

    public boolean removeCourse(int id) {
        Course course = courseDao.findById(id);
        if (course != null) {
            return courseDao.removeCourse(course);
        }
        return false;
    }

    public void registerStudentToCourse(int studentId, int courseId, StudentService studentService) {
        Student student = studentService.findStudentById(studentId);
        Course course = findCourseById(courseId);

        if (student != null && course != null) {
            course.register(student);
            System.out.println("Student registered to course!");
        } else {
            System.out.println("Student or Course not found!");
        }
    }
}
