package hangman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResultTest {

    @Test
    public void testToString() {
        assertThat(
                new Result(Boolean.TRUE, new Integer(0), new Integer(5)).toString(),
                containsString("Hit!"));
    }

    @Test
    public void testToString_Miss() {
        assertThat(
                new Result(Boolean.FALSE, new Integer(1), new Integer(5)).toString(),
                containsString("Missed, mistake #1 out of 5"));
    }
}
