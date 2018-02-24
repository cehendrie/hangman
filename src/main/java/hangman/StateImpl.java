package hangman;

import java.io.OutputStream;

public class StateImpl implements State{

    private Guess guess;
    private Word word;
    private Integer mistakes;
    private Integer maxMistakes;
    private OutputStream output;

    public StateImpl(Guess guess, Word word, Integer maxMistakes, OutputStream output) {
        this.guess = guess;
        this.word = word;
        this.maxMistakes = maxMistakes;
        this.output = output;
        this.mistakes = new Integer(0);
    }

    public Boolean hasNextGuess() {

        if (this.word.isWinner()) {
            return Boolean.FALSE;
        }

        if (this.mistakes >= this.maxMistakes) {
            return Boolean.FALSE;
        }

        return Boolean.TRUE;
    }

    public void nextGuess() {

        Character guess = this.guess.scan();

        Boolean hit = this.word.update(guess);

        if (!hit) {
            this.mistakes++;
        }

        if (hasNextGuess()) {
            new ResultPrinterImpl(new Result(hit, this.mistakes, this.maxMistakes), this.output).print();
            new WordPrinterImpl(this.word, this.output).print();
        }
    }

    @Override
    public String toString() {

        String result = "";

        if (!hasNextGuess()) {

            if (this.word.isWinner()) {
                result = "You win!\n";
            }

            if (this.mistakes >= this.maxMistakes) {
                result = "You lose!\n";
            }
        }

        return result;
    }
}
