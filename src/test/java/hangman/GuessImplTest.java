package hangman;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GuessImplTest {

    @Test
    public void testScan() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        assertThat(
                new GuessImpl(input, output).scan(),
                is(new Character('a')));
    }
}
