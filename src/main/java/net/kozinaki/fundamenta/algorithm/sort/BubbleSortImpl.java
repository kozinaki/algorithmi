package net.kozinaki.fundamenta.algorithm.sort;

public class BubbleSortImpl implements Sort {

    @Override
    public int[] sort(int[] unsorted) {
        for (int right = unsorted.length - 1; right > 0; right--) {
            for (int current = 0; current < right; current++) {
                if (unsorted[current] > unsorted[current + 1]) {
                    swap(unsorted, current, current + 1);
                }
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
