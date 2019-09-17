package net.kozinaki.algorithmi.sort;

import java.util.Arrays;

public abstract class Sort {

    protected static Sort instance;

    public static void main(String args[]) {
        int size = Integer.parseInt(args[0]);
        int[] unsorted = new int[size];
        for(int i = 0; i < unsorted.length; i++)
            unsorted[i] = (int)(Math.random() * size + 1);
        System.out.println(Arrays.toString(unsorted));
        System.out.println(Arrays.toString(instance.go(unsorted)));
    }

    protected int[] go(int[] unsorted) {
        long time = System.currentTimeMillis();
        int[] sorted = sort(unsorted);
        time = System.currentTimeMillis() - time;
        System.out.println(" - " + (time / 1000.0));
        return sorted;
    }

    protected abstract int[] sort(int[] unsorted);

    protected void swap(int[] array, int i, int j) {
        array[j] += array[i];
        array[i] = array[j] - array[i];
        array[j] -= array[i];
    }


}
