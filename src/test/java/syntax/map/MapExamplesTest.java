package syntax.map;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;

public class MapExamplesTest {

    @Test
    public void otherEntriesRemainInTheMapWhenWinterMonthsRemoved() throws ParseException {
        // preparing test data
        List<Date> datesList = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        for (int i = 1; i < 10; i++) datesList.add(formatter.parse("11/0" + i + "/2000"));
        datesList.add(formatter.parse("11/10/2000"));
        datesList.add(formatter.parse("11/11/2000"));
        datesList.add(formatter.parse("11/12/2000"));
        HashMap<String, Date> map = new HashMap<>();
        for (Date date : datesList) map.put(String.valueOf(datesList.indexOf(date)), date);

        // removing elements from map
        MapExamples.removeAllEntriesForJanuary(map, 11);
        MapExamples.removeAllEntriesForJanuary(map, 0);
        MapExamples.removeAllEntriesForJanuary(map, 1);

        // validating expected elements remain in the map
        for (int i = 2; i < 11; i++) {
            assertThat(map.values(), hasItem(datesList.get(i)));
        }

        // validating removed elements absent in map
        assertThat(map.values(), not(hasItem(datesList.get(11))));
        assertThat(map.values(), not(hasItem(datesList.get(0))));
        assertThat(map.values(), not(hasItem(datesList.get(1))));
    }
}