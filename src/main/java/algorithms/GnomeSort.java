package algorithms;

public class GnomeSort {

    public static void sort(String[] array) {
        // gnome sort
        int pos = 0;
        while (pos < array.length) {
            if (pos == 0 || !isGreaterThan(array[pos - 1], array[pos])) pos++;
            else {
                String temp = array[pos - 1];
                array[pos - 1] = array[pos];
                array[pos] = temp;

                pos--;
            }
        }
    }

    private static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}