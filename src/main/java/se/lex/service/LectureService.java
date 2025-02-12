package se.lex.service;

import se.lex.model.Lecture;
import se.lex.model.Teacher;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LectureService {
    private final List<Lecture> lectures = new ArrayList<>();

    public void createLecture( String topic, LocalDateTime dateTime, List<Teacher> teachers) {
        Lecture lecture = new Lecture( topic, dateTime, teachers);
        lectures.add(lecture);
        System.out.println("Lecture created!");
    }

    public Lecture findLectureById(int id) {
        return lectures.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Lecture> findAllLectures() {
        return new ArrayList<>(lectures);
    }
}
