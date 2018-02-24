package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class StatePrinterImpl implements StatePrinter {

    private State state;
    private PrintStream printStream;

    public StatePrinterImpl(State state, OutputStream outputStream) {
        this.state = state;
        this.printStream = new PrintStream(outputStream);
    }

    public void print() {
        this.printStream.print(this.state.toString());
    }
}
