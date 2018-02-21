package hangman;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResultPrinterImplTest {

    @Test
    public void testPrint() {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        new ResultPrinterImpl(new Result(Boolean.TRUE, new Integer(0), new Integer(5)), output).print();
        assertThat(output.toString(), containsString("Hit!"));
    }
}
