package net.kozinaki.fundamenta.algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SortTest {

    private static final int SIZE = 100;

    @Test
    public void testBubbleSort() {
        //int size = Integer.parseInt(args[0]);
        int size = SIZE;
        int[] unsorted = new int[size];
        for(int i = 0; i < unsorted.length; i++) {
            unsorted[i] = (int) (Math.random() * size + 1);
        }
        System.out.println(Arrays.toString(unsorted));
        System.out.println(Arrays.toString(go(new BubbleSortImpl(), unsorted)));
        System.out.println(Arrays.toString(go(new BubbleSortImpl(), unsorted)));
        System.out.println(Arrays.toString(go(new BubbleSortImpl(), unsorted)));
    }

    private <T> int[] go(Sort sort, int[] unsorted) {
        long time = System.currentTimeMillis();
        int[] sorted = sort.sort(unsorted);
        time = System.currentTimeMillis() - time;
        System.out.println(" - " + (time / 1000.0));
        return sorted;
    }

}
