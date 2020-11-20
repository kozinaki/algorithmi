package net.kozinaki.fundamenta.algorithm.sort;

public class InsertSortImpl implements Sort {

    @Override
    public int[] sort(int[] unsorted) {
        for (int i = 1; i < unsorted.length; i++) {
            int j = i;
            int temp = unsorted[i];
            while(j > 0 && unsorted[j - 1] >= temp) {
                unsorted[j] = unsorted[j - 1];
                j--;
            }
            unsorted[j] = temp;
        }
        int[] sorted = unsorted;
        return sorted;
    }

}

