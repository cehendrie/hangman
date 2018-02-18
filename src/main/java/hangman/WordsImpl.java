package hangman;

import java.util.Random;

public class WordsImpl implements Words {

    private static final String[] WORDS = {
            "simplicity",
            "equality",
            "grandmother",
            "neighborhood",
            "relationship",
            "mathematics",
            "university",
            "explanation"
    };


    public String retrieve() {
        String word = WORDS[new Random().nextInt(WORDS.length)];
        return word;
    }
}
