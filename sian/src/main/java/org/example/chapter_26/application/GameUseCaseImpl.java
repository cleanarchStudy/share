package org.example.chapter_26.application;

import org.example.chapter_26.domain.GameRepository;

public class GameUseCaseImpl implements GameUseCase {

    private final GameRepository repository;

    public GameUseCaseImpl(final GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public void startGame() {

    }

    @Override
    public void endGame() {

    }
}
