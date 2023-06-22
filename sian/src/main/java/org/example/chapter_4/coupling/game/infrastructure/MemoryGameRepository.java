package org.example.chapter_4.coupling.game.infrastructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.example.chapter_4.coupling.game.domain.Game;
import org.example.chapter_4.coupling.game.domain.GameRepository;

public class MemoryGameRepository implements GameRepository {

    private final Map<Long, Game> persistence = new HashMap<>();
    private long sequence = 0L;

    @Override
    public Long save(final Game game) {
        persistence.put(sequence++, game);
        return sequence;
    }

    @Override
    public Optional<Game> findById(final Long id) {
        return Optional.ofNullable(persistence.get(id));
    }
}
