package hangman;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

public class StatePrinterImplTest {

    @Test
    public void testPrint() {

        State stateMock = Mockito.mock(State.class);

        when(stateMock.toString()).thenReturn("You win!\n");

        final ByteArrayOutputStream output = new ByteArrayOutputStream();

        new StatePrinterImpl(stateMock, output).print();

        assertThat(output.toString(), containsString("win"));
    }
}