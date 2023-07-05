package org.example.chapter_22.lecture.application.port.out;

import org.example.chapter_22.lecture.domain.model.Lecture;

public interface LectureRepositoryPort {

    void save(Lecture lecture);
}
