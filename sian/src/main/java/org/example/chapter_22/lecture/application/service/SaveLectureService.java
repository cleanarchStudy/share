package org.example.chapter_22.lecture.application.service;

import org.example.chapter_22.lecture.application.port.in.SaveLectureCommand;
import org.example.chapter_22.lecture.application.port.in.SaveLectureUseCase;
import org.example.chapter_22.lecture.application.port.out.LectureRepositoryPort;

public class SaveLectureService implements SaveLectureUseCase {

    private final LectureRepositoryPort lectureRepositoryPort;

    public SaveLectureService(final LectureRepositoryPort lectureRepositoryPort) {
        this.lectureRepositoryPort = lectureRepositoryPort;
    }

    @Override
    public void saveLecture(final SaveLectureCommand command) {
    }
}
