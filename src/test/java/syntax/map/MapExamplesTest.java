package syntax.map;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static syntax.map.MapExamples.initializeMapDuringCreationUsingAnonymousClass;

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

    @Test
    public void removeIfFrequencyMoreThanTwo() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put("key: " + i, "value: " + (i % 2));
        }

        MapExamples.removeElementForFrequencyMoreThan(map, 2);
        assertThat(map.values(), not(hasItem("value: 0")));
        assertThat(map.values(), hasItem("value: 1"));
    }

    @Test
    public void mapIsEmptyAfterRemovingDuplicates() {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 6; i++) {
            map.put("key: " + i, "value: " + (i % 2));
        }

        MapExamples.removeElementForFrequencyMoreThan(map, 2);
        assertThat(map.size(), is(0));
    }

    @Test
    public void mapContainsValuesAfterInitialization() {
        String test1 = "test 1", test2 = "test 2";
        Map<Integer, String> map = initializeMapDuringCreationUsingAnonymousClass(test1, test2);

        assertThat(map.values(), hasItems(test1, test2));
    }
}