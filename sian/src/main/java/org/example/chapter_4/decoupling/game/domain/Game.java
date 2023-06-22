package org.example.chapter_4.decoupling.game.domain;

import java.util.Objects;

public class Game {

    private String words;
    private Status status;

    public Game(final String words) {
        this.words = words;
        this.status = status = Status.PLAYING;
    }

    public Status getStatus() {
        return status;
    }

    public GameResult isMatched(String words) {
        if (Objects.equals(this.words, words)) {
            this.status = Status.FINISHED;
            return GameResult.CORRECT;
        }
        return GameResult.WRONG;
    }

    private enum Status {
        PLAYING, FINISHED
    }
}
