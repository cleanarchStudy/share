package org.example.chapter_4.coupling.history.infrastructure;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.chapter_4.coupling.history.domain.History;
import org.example.chapter_4.coupling.history.domain.HistoryRepository;

public class MemoryHistoryRepository implements HistoryRepository {

    private final Map<Long, History> persistence = new HashMap<>();
    private long sequence = 0L;

    @Override
    public void save(final History history) {
        persistence.put(sequence++, history);
    }

    @Override
    public List<History> findAllByGameId(final Long gameId) {
        return persistence.entrySet()
            .stream()
            .filter(entry -> entry.getValue().getGameId().equals(gameId))
            .map(Map.Entry::getValue)
            .toList();
    }
}
