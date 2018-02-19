package hangman;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordPrinterImplTest {

    @Test
    public void testPrint() {

        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        new WordPrinterImpl(new WordImpl("test"), output).print();

        assertThat(output.toString(), containsString("????"));
    }
}
