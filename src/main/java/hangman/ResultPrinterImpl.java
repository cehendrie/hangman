package hangman;

import java.io.OutputStream;
import java.io.PrintStream;

public class ResultPrinterImpl {

    private Result result;
    private PrintStream printStream;

    public ResultPrinterImpl(Result result, OutputStream outputStream) {
        this.result = result;
        this.printStream = new PrintStream(outputStream);
    }

    public void print() {
        this.printStream.print(this.result.toString());
    }
}
