package org.example.chapter_4.decoupling.history.domain;

import java.util.List;

public interface HistoryRepository {

    void save(History history);

    List<History> findAllByGameId(Long gameId);
}
