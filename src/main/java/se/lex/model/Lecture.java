package se.lex.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Lecture {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String topic;
    private LocalDateTime dateTime;
    private List<Teacher> teachers;

    public Lecture( String topic, LocalDateTime dateTime, List<Teacher> teachers) {
        this.id = count.incrementAndGet();
        this.topic = topic;
        this.dateTime = dateTime;
        this.teachers = teachers;
    }

    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lecture lecture = (Lecture) o;
        return Objects.equals(topic, lecture.topic) && Objects.equals(dateTime, lecture.dateTime) && Objects.equals(teachers, lecture.teachers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, dateTime, teachers);
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "id=" + id +
                ", topic='" + topic + '\'' +
                ", dateTime=" + dateTime +
                ", teachers=" + teachers +
                '}';
    }
}
