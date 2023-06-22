package org.example.chapter_4.coupling.game.domain;

import java.util.Optional;

public interface GameRepository {

    Long save(final Game game);

    Optional<Game> findById(final Long id);
}
