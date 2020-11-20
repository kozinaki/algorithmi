package net.kozinaki.fundamenta.algorithm.sort;

public class SelectSortImpl implements Sort {

    @Override
    public int[] sort(int[] unsorted) {
        for (int left = 0; left < unsorted.length - 1; left++) {
            int min = left;
            for (int current = left + 1; current < unsorted.length; current++) {
                if (unsorted[current] < unsorted[min]) {
                    min = current;
                }
            }
            if (min != left) {
                swap(unsorted, left, min);
            }
        }
        int[] sorted = unsorted;
        return sorted;
    }

    protected void swap(int[] array, int i, int j) {
        array[j] += array[i];
        array[i] = array[j] - array[i];
        array[j] -= array[i];
    }

}
