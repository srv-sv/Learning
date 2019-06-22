package puzzlers.puzzle27;

import org.junit.Test;
import utils.StreamsReplacer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SolutionTest extends StreamsReplacer {

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
}