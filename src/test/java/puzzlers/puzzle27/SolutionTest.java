package puzzlers.puzzle27;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SolutionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void methodPrints32ForInt() {
        Solution.main(new String[]{"int"});
        assertThat(outContent.toString(), is("32")); // explanation: https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.19
    }

    @Test
    public void methodPrints64ForLong() {
        Solution.main(new String[]{"long"});
        assertThat(outContent.toString(), is("64"));
    }

    @Test
    public void methodDoesNotReturnAnythingForEmptyArgs() {
        Solution.main(new String[]{});
        assertThat(outContent.toString(), is(""));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }
}