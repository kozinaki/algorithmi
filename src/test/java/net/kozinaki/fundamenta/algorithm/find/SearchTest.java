package net.kozinaki.fundamenta.algorithm.find;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SearchTest {

    private static final int SIZE = 100;

    @Test
    public void testSearch() {
        int size = SIZE;
        int[] unsorted = new int[size];
        for(int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * size + 1);
        }
        System.out.println(Arrays.toString(unsorted));
        System.out.println(go(new LinearSearch(), unsorted, (int) (Math.random() * size + 1)));
        System.out.println(go(new SentinelLinearSearch(), unsorted, (int) (Math.random() * size + 1)));
    }

    @Test
    public void testMediana() {
        int size = SIZE;
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * size) + 1);
        }
        System.out.println(Arrays.toString(array));
        Mediana mediana = new Mediana();
        mediana.getMediana(array);
        mediana.sort(array);
        System.out.println(Arrays.toString(array));
    }

    private int go(Search searcher, int[] data, int value) {
        long time = System.currentTimeMillis();
        int result = searcher.search(data, value);
        time = System.currentTimeMillis() - time;
        System.out.println(" - " + (time / 1000.0));
        return result;
    }

}
