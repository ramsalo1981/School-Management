package se.lex.dao;

import se.lex.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao{
    private static final List<Student> students = new ArrayList<>();

    @Override
    public Student saveStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot save a null student.");
        }
        students.add(student);
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null.");
        }
        for (Student student : students) {
            if (student.getEmail().equalsIgnoreCase(email)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null.");
        }
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public boolean deleteStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Cannot delete a null student.");
        }
        return students.remove(student);
    }
}
