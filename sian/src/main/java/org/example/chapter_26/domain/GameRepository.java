package org.example.chapter_26.domain;

public interface GameRepository {

    void save(Game game);

    Game find();
}
