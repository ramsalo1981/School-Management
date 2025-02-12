package se.lex;

import se.lex.model.Course;
import se.lex.model.Student;
import se.lex.service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // Initialize services
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        TeacherService teacherService = new TeacherService();
        LectureService lectureService = new LectureService();

        // Initialize and start the console menu
        MenuService menu = new MenuService(
                studentService,
                courseService,
                teacherService,
                lectureService
        );
        menu.start();
    }
}