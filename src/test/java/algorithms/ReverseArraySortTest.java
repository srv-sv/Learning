package algorithms;

import org.junit.Test;
import utils.StreamsReplacer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ReverseArraySortTest extends StreamsReplacer {

    @Test
    public void firstElementIsLargestAfterReverseSort() {
        ReverseArraySort.main(new String[]{});
        assertThat(outContent.toString(), is("4"));
    }

    // todo:
    //  1) add more tests;
    //  2) use input streams, e.g. https://stackoverflow.com/questions/32442435/inputstream-new-class-that-extends-inputstream
}