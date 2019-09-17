package net.kozinaki.algorithmi.sort;

public class BubbleSorterImpl extends Sort {

    static {
        Sort.instance = new InsertSorterImpl();
    }

    @Override
    public int[] sort(int[] unsorted) {
        for(int right = unsorted.length - 1; right > 0; right--)
            for(int current = 0; current < right; current++)
                if(unsorted[current] > unsorted[current + 1]) {
                    swap(unsorted, current, current + 1);
                }
        int[] sorted = unsorted;
        return sorted;
    }

}
