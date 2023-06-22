package org.example.chapter_4.decoupling.game.domain;

public interface GameDeliveredService {

    void deliverGame(final Long gameId, final String words, final String result);
}
