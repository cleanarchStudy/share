package org.example.chapter_26;

import org.example.chapter_26.application.GameUseCaseImpl;
import org.example.chapter_26.domain.GameRepository;
import org.example.chapter_26.infrastructure.file.FileGameRepository;
import org.example.chapter_26.presentation.ConsoleController;

public class GameApplication {

    public static void main(String[] args) {
        final GameRepository repository = new FileGameRepository();
        final GameUseCaseImpl useCase = new GameUseCaseImpl(repository);
        final ConsoleController controller = new ConsoleController(useCase);

        controller.startGame();
        controller.endGame();
    }
}
