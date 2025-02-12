package se.lex.dao;

import se.lex.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoList implements StudentDao{
    private static List<Student> students = new ArrayList<>();
    @Override
    public Student saveStudent(Student student) {
        if(!students.contains(student)){
            students.add(student);
        }
        return student;
    }

    @Override
    public Student findByEmail(String email) {
        for(Student student:students){
            if(student.getEmail().equalsIgnoreCase(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public List<Student> findByName(String name) {
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
        return students.remove(student);
    }
}
