package hangman;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WordsImplTest {

    @Test
    public void testRetrieve() {
        assertThat(new WordsImpl().retrieve(), is(notNullValue()));
    }
}
