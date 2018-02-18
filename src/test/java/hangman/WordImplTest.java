package hangman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordImplTest {

    @Test
    public void testUpdate() {
        assertThat(
                new WordImpl("test").update(new Character('t')),
                is(Boolean.TRUE));
    }

    @Test
    public void testUpdate_Miss() {
        assertThat(
                new WordImpl("test").update(new Character('z')),
                is(Boolean.FALSE));
    }

    @Test
    public void testIsWinner() {
        Word word = new WordImpl("test");
        word.update(new Character('t'));
        word.update(new Character('e'));
        word.update(new Character('s'));
        assertThat(word.isWinner(), is(Boolean.TRUE));
    }

    @Test
    public void testIsWinner_False() {
        assertThat(new WordImpl("test").isWinner(), is(Boolean.FALSE));
    }

    @Test
    public void testToString() {
        assertThat(new WordImpl("test").toString(), containsString("The word: ????"));
    }

    @Test
    public void testToStringWithHit() {
        Word word = new WordImpl("test");
        word.update(new Character('t'));
        assertThat(word.toString(), containsString("The word: t??t"));
    }
}
