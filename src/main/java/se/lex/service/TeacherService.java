package se.lex.service;

import se.lex.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class TeacherService {
    private final List<Teacher> teachers = new ArrayList<>();

    public void createTeacher( String name) {
        Teacher teacher = new Teacher( name);
        teachers.add(teacher);
        System.out.println("Teacher created!");
    }

    public Teacher findTeacherById(int id) {
        return teachers.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Teacher> findAllTeachers() {
        return new ArrayList<>(teachers);
    }
}
