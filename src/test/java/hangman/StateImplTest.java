package hangman;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StateImplTest {

    @Test
    public void testHasNextGuess() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        assertThat(
                new StateImpl(
                        new GuessImpl(input, output),
                        new WordImpl("test"),
                        new Integer(1), output).hasNextGuess(),
                is(Boolean.TRUE));
    }

    @Test
    public void testHasNextGuess_FalseWinner() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        final Word word = new WordImpl("test");
        word.update(new Character('t'));
        word.update(new Character('e'));
        word.update(new Character('s'));

        assertThat(
                new StateImpl(
                        new GuessImpl(input, output),
                        word,
                        new Integer(1), output).hasNextGuess(),
                is(Boolean.FALSE));
    }

    @Test
    public void testHasNextGuess_FalseMaxMistakes() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        assertThat(
                new StateImpl(
                        new GuessImpl(input, output),
                        new WordImpl("test"),
                        new Integer(0), output).hasNextGuess(),
                is(Boolean.FALSE));
    }

    @Test
    public void testNextGuess() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        Word word = new WordImpl("test");

        new StateImpl(
                new GuessImpl(input, output),
                word,
                new Integer(5), output).nextGuess();

        assertThat(word.toString(), containsString("????"));
    }

    @Test
    public void testToString() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        assertThat(
                new StateImpl(
                        new GuessImpl(input, output),
                        new WordImpl("test"),
                        new Integer(5), output).toString(),
                is(""));
    }

    @Test
    public void testToString_Winner() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        final Word word = new WordImpl("test");
        word.update(new Character('t'));
        word.update(new Character('e'));
        word.update(new Character('s'));

        assertThat(
                new StateImpl(
                        new GuessImpl(input, output),
                        word,
                        new Integer(5), output).toString(),
                containsString("You win!"));
    }

    @Test
    public void testToString_Loser() {

        final ByteArrayInputStream input =
                new ByteArrayInputStream("a\na\na\na\na\n".getBytes());
        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        final Word word = new WordImpl("test");
        word.update(new Character('z'));

        State state =
                new StateImpl(
                        new GuessImpl(input, output),
                        word,
                        new Integer(1), output);
        state.nextGuess();

        assertThat(
                state.toString(),
                containsString("You lose!"));
    }
}
