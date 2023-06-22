package org.example.chapter_4.decoupling.game.domain;

import java.util.Optional;

public interface GameRepository {

    Long save(Game game);

    Optional<Game> findById(Long id);
}
