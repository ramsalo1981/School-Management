package se.lex.service;

import se.lex.dao.StudentDao;
import se.lex.dao.StudentDaoList;
import se.lex.model.Student;

import java.util.List;

public class StudentService {
    private final StudentDao studentDao = new StudentDaoList();

    public void createStudent( String name, String email, String address) {
        Student student = new Student( name, email, address);
        studentDao.saveStudent(student);
        System.out.println("Student created!");
    }

    public Student findStudentById(int id) {
        return studentDao.findById(id);
    }

    public List<Student> findStudentsByName(String name) {
        return studentDao.findByName(name);
    }

    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    public boolean deleteStudent(int id) {
        Student student = studentDao.findById(id);
        if (student != null) {
            return studentDao.deleteStudent(student);
        }
        return false;
    }
}
