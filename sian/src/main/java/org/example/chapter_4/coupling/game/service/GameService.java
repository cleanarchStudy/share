package org.example.chapter_4.coupling.game.service;

import org.example.chapter_4.coupling.game.domain.Game;
import org.example.chapter_4.coupling.game.domain.GameRepository;
import org.example.chapter_4.coupling.game.domain.GameResult;
import org.example.chapter_4.coupling.history.domain.History;
import org.example.chapter_4.coupling.history.domain.HistoryRepository;

public class GameService {

    private final GameRepository gameRepository;
    private final HistoryRepository historyRepository;

    public GameService(
        final GameRepository gameRepository,
        final HistoryRepository historyRepository
    ) {
        this.gameRepository = gameRepository;
        this.historyRepository = historyRepository;
    }

    public Long createGame() {
        return gameRepository.save(new Game("apple"));
    }

    public GameResult guess(final Long gameId, final String words) {
        final Game game = gameRepository.findById(gameId).orElseThrow();
        final GameResult result = game.isMatched(words);

        historyRepository.save(new History(gameId, words, result.name()));

        return result;
    }
}
