package hangman;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class GameImplTest {

    @Test
    public void testStart() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("t\ne\ns\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        new GameImpl(new WordImpl("test"), input, output, new Integer(5)).start();

        assertThat(output.toString(), containsString("You win!"));
    }


    @Test
    public void testStart_Lose() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        new GameImpl(new WordImpl("test"), input, output, new Integer(1)).start();

        assertThat(output.toString(), containsString("You lose!"));
    }
}
