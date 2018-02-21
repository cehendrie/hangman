package hangman;

public class Result {

    private Boolean isHit;
    private Integer mistakes;
    private Integer maxMistakes;

    public Result(Boolean isHit, Integer mistakes, Integer maxMistakes) {
        this.isHit = isHit;
        this.mistakes = mistakes;
        this.maxMistakes = maxMistakes;
    }

    @Override
    public String toString() {
        if (isHit) {
            return "Hit!\n";
        } else {
            return String.format("Missed, mistake #%d out of %d\n", this.mistakes, this.maxMistakes);
        }
    }
}
