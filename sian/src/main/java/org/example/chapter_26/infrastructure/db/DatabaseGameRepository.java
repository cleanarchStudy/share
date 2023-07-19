package org.example.chapter_26.infrastructure.db;

import org.example.chapter_26.domain.Game;
import org.example.chapter_26.domain.GameRepository;

public class DatabaseGameRepository implements GameRepository {

    @Override
    public void save(final Game game) {

    }

    @Override
    public Game find() {
        return null;
    }
}
