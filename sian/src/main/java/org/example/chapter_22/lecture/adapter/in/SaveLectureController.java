package org.example.chapter_22.lecture.adapter.in;

import org.example.chapter_22.lecture.application.port.in.SaveLectureUseCase;

public class SaveLectureController {

    private final SaveLectureUseCase saveLectureUseCase;

    public SaveLectureController(final SaveLectureUseCase saveLectureUseCase) {
        this.saveLectureUseCase = saveLectureUseCase;
    }
}
