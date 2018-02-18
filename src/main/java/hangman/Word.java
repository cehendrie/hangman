package hangman;

public interface Word {

    Boolean update(Character guess);
    Boolean isWinner();
}
