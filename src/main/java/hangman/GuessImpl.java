package hangman;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class GuessImpl implements Guess {

    private final Iterator<String> scanner;
    private final PrintStream printStream;

    public GuessImpl(InputStream input, OutputStream output) {
        this.printStream = new PrintStream(output);
        this.scanner = new Scanner(input);
    }

    public Character scan() {
        this.printStream.print("Guess a letter: ");
        char chr = this.scanner.next().charAt(0);
        return chr;
    }
}
