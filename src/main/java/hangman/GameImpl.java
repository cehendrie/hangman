package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class GameImpl implements Game {

    private final Word word;
    private final InputStream inputStream;
    private final OutputStream outputStream;
    private final Integer maxMistakes;

    public GameImpl(Word word, InputStream inputStream, OutputStream outputStream, Integer maxMistakes) {
        this.word = word;
        this.inputStream = inputStream;
        this.outputStream = outputStream;
        this.maxMistakes = maxMistakes;
    }

    public static void main(final String... args) {
        new GameImpl(
                new WordImpl(new WordsImpl().retrieve()),
                System.in,
                System.out,
                5).start();
    }

    public void start() {

        State state =
                new StateImpl(
                        new GuessImpl(this.inputStream, this.outputStream),
                        this.word,
                        this.maxMistakes,
                        this.outputStream);

        while (state.hasNextGuess()) {
            state.nextGuess();
        }

        new StatePrinterImpl(state, this.outputStream).print();
    }
}
