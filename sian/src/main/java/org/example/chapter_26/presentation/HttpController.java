package org.example.chapter_26.presentation;

import org.example.chapter_26.application.GameUseCase;

public class HttpController {

    private final GameUseCase gameUseCase;

    public HttpController(final GameUseCase gameUseCase) {
        this.gameUseCase = gameUseCase;
    }

    public void startGame() {
        gameUseCase.startGame();
    }

    public void endGame() {
        gameUseCase.endGame();
    }
}
