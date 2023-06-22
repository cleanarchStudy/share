package org.example.chapter_4.decoupling.history.service;

import org.example.chapter_4.coupling.history.domain.History;
import org.example.chapter_4.coupling.history.domain.HistoryRepository;
import org.example.chapter_4.decoupling.game.domain.GameDeliveredService;

public class GameDeliveredServiceImpl implements GameDeliveredService {

    private final HistoryRepository historyRepository;

    public GameDeliveredServiceImpl(final HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void deliverGame(final Long gameId, final String words, final String result) {
        this.historyRepository.save(new History(gameId, words, result));
    }
}
