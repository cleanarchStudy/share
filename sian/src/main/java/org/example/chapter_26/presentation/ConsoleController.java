package org.example.chapter_26.presentation;

import org.example.chapter_26.application.GameUseCase;

public class ConsoleController {

    private final GameUseCase gameUseCase;

    public ConsoleController(final GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public void startGame() {
        gameUseCase.startGame();
    }

    public void endGame() {
        gameUseCase.endGame();
    }
}
