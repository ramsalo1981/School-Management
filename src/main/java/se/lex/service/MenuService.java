package se.lex.service;

import se.lex.model.Course;
import se.lex.model.Lecture;
import se.lex.model.Student;
import se.lex.model.Teacher;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    private final StudentService studentService;
    private final CourseService courseService;
    private final TeacherService teacherService;
    private final LectureService lectureService;
    private final Scanner scanner;

    public MenuService(
            StudentService studentService,
            CourseService courseService,
            TeacherService teacherService,
            LectureService lectureService
    ) {
        this.studentService = studentService;
        this.courseService = courseService;
        this.teacherService = teacherService;
        this.lectureService = lectureService;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            while (true) {
                System.out.println("\n1. Create Student\n2. Create Course\n3. Register Student to Course");
                System.out.println("4. Find Student\n5. Find Course\n6. Find All Students");
                System.out.println("7. Find All Courses\n8. Find All Lectures\n9. Find All Teachers\n10. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1 -> createStudent();
                    case 2 -> createCourse();
                    case 3 -> registerStudentToCourse();
                    case 4 -> findStudent();
                    case 5 -> findCourse();
                    case 6 -> findAllStudents();
                    case 7 -> findAllCourses();
                    case 8 -> findAllLectures();
                    case 9 -> findAllTeachers();
                    case 10 -> System.exit(0);
                    default -> System.out.println("Invalid option!");
                }
            }
        }
    }

    private void createStudent() {

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        studentService.createStudent(name, email, address);
    }

    private void createCourse() {

        System.out.print("Enter Course Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Start Date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());
        System.out.print("Enter Duration (weeks): ");
        int duration = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Teacher Name: ");
        String teacherName = scanner.nextLine();


        Teacher teacher = new Teacher(teacherName);
        teacherService.createTeacher(teacherName);
        courseService.createCourse(name, startDate, duration, teacher);
    }

    private void registerStudentToCourse() {
        System.out.print("Enter Student ID: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Course ID: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();

        courseService.registerStudentToCourse(studentId, courseId, studentService);
    }

    private void findStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Student student = studentService.findStudentById(id);
        if (student != null) {
            System.out.println("Student: " + student.getName());
            System.out.println("Courses: " + student.getCourses().stream().map(Course::getCourseName).toList());
        } else {
            System.out.println("Student not found!");
        }
    }

    private void findCourse() {
        System.out.print("Enter Course ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Course course = courseService.findCourseById(id);
        if (course != null) {
            System.out.println("Course: " + course.getCourseName());
            System.out.println("Students: " + course.getStudents().stream().map(Student::getName).toList());
        } else {
            System.out.println("Course not found!");
        }
    }

    private void findAllStudents() {
        List<Student> students = studentService.findAllStudents();
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        System.out.println("\nAll Students:");
        students.forEach(s -> System.out.println(
                "ID: " + s.getId() + ", Name: " + s.getName() + ", Email: " + s.getEmail()
        ));
    }

    private void findAllCourses() {
        List<Course> courses = courseService.findAllCourses();
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
            return;
        }
        System.out.println("\nAll Courses:");
        courses.forEach(c -> System.out.println(
                "ID: " + c.getId() + ", Name: " + c.getCourseName() + ", Start Date: " + c.getStartDate()
        ));
    }

    private void findAllLectures() {
        List<Lecture> lectures = lectureService.findAllLectures();
        if (lectures.isEmpty()) {
            System.out.println("No lectures found.");
            return;
        }
        System.out.println("\nAll Lectures:");
        lectures.forEach(l -> System.out.println(
                "ID: " + l.getId() + ", Topic: " + l.getTopic() + ", Date: " + l.getDateTime()
        ));
    }

    private void findAllTeachers() {
        List<Teacher> teachers = teacherService.findAllTeachers();
        if (teachers.isEmpty()) {
            System.out.println("No teachers found.");
            return;
        }
        System.out.println("\nAll Teachers:");
        teachers.forEach(t -> System.out.println(
                "ID: " + t.getId() + ", Name: " + t.getName()
        ));
    }
}
