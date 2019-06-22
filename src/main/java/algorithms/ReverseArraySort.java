package algorithms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArraySort {

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[5];

        for (int i = 0; i < array.length; i++) {
            array[i] = i;//Integer.parseInt(reader.readLine());
        }

        sort(array);

        System.out.print(array[0]);
    }

    private static void sort(int[] array) {
        Arrays.sort(array);
        reverseOrder(array);
    }

    private static void reverseOrder(int[] array) {
        int length = array.length;

        for (int i = 0; i < length/2; i++) {
            swap(array, i, length - 1 - i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}