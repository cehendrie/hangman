package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class WordPrinterImpl {

    private Word word;
    private PrintStream printStream;

    public WordPrinterImpl(Word word, OutputStream output) {
        this.word = word;
        this.printStream = new PrintStream(output);
    }

    public void print() {
        this.printStream.print(this.word.toString());
    }
}
