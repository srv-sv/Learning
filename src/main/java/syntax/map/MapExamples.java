package syntax.map;

import java.util.*;

public class MapExamples {
    public static void main(String[] args) {
    }

    static void removeAllEntriesForJanuary(HashMap<String, Date> map, int month) {
        Calendar calendar = Calendar.getInstance();

        map
                .values()
                .removeIf(value -> {
                    calendar.setTime(value);
                    return (calendar.get(Calendar.MONTH) == month);
                });
    }

    static <V, E> void removeElementForFrequencyMoreThan(Map<V, E> map, int frequency) {
        Map<E, Integer> mapOfFrequencies = calculateElementFrequenceInMap(map);

        mapOfFrequencies
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > frequency)
                .forEach(
                        entry -> {
                            removeDuplicateValues(map, entry.getKey());
                        });
    }

    private static <V, E> void removeDuplicateValues(Map<V, E> map, E value) {
        map.entrySet().removeIf(entry -> value.equals(entry.getValue()));
    }

    private static <V, E> Map<E, Integer> calculateElementFrequenceInMap(Map<V, E> map) {
        Map<E, Integer> mapOfFrequencies = new HashMap<>();
        for (E value : new HashSet<>(map.values())) {
            mapOfFrequencies.put(value, Collections.frequency(map.values(), value));
        }
        return mapOfFrequencies;
    }
}