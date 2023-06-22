package org.example.chapter_4.decoupling.game.service;

import org.example.chapter_4.decoupling.game.domain.Game;
import org.example.chapter_4.decoupling.game.domain.GameDeliveredService;
import org.example.chapter_4.decoupling.game.domain.GameRepository;
import org.example.chapter_4.decoupling.game.domain.GameResult;

public class GameService {

    private final GameRepository gameRepository;
    private final GameDeliveredService gameDeliveredService;

    public GameService(
        final GameRepository gameRepository,
        final GameDeliveredService gameDeliveredService) {
        this.gameRepository = gameRepository;
        this.gameDeliveredService = gameDeliveredService;
    }

    public Long createGame() {
        return gameRepository.save(new Game("apple"));
    }

    public GameResult guess(final Long gameId, final String words) {
        final Game game = gameRepository.findById(gameId).orElseThrow();
        final GameResult result = game.isMatched(words);

        gameDeliveredService.deliverGame(gameId, words, result.name());

        return result;
    }
}
