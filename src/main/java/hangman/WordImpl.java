package hangman;

import java.util.ArrayList;
import java.util.List;

public class WordImpl implements Word {

    final private String word;
    private List<Boolean> visibility;

    public WordImpl(String word) {

        this.word = word;
        this.visibility = new ArrayList<Boolean>(this.word.length());

        for (Character c : word.toCharArray()) {
            this.visibility.add(Boolean.FALSE);
        }
    }

    public Boolean update(Character guess) {

        Boolean hit = Boolean.FALSE;

        for (int i = 0; i < word.length(); ++i) {
            Character c = word.charAt(i);
            if (guess.equals(c)) {
                hit = Boolean.TRUE;
                this.visibility.set(i, hit);
            }
        }

        return hit;
    }

    public Boolean isWinner() {
        for(Boolean b : this.visibility) {
            if (!b) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    @Override
    public String toString() {

        StringBuffer stringBuffer = new StringBuffer("The word: ");

        for (int i = 0; i < this.word.length(); ++i) {
            if (this.visibility.get(i)) {
                stringBuffer.append(this.word.charAt(i));
            } else {
                stringBuffer.append("?");
            }
        }

        stringBuffer.append("\n\n");

        return stringBuffer.toString();
    }
}
