package hangman;

public interface State {
    Boolean hasNextGuess();
    void nextGuess();
}
