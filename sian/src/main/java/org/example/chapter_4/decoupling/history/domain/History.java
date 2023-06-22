package org.example.chapter_4.decoupling.history.domain;

public class History {

    private Long gameId;
    private String answer;
    private String result;

    public History(final Long gameId, final String answer, final String result) {
        this.gameId = gameId;
        this.answer = answer;
        this.result = result;
    }

    public Long getGameId() {
        return gameId;
    }

    public String getAnswer() {
        return answer;
    }

    public String getResult() {
        return result;
    }
}
