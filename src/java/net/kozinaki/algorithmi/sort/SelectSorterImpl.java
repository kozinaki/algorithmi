package net.kozinaki.algorithmi.sort;

public class SelectSorterImpl implements Sorter {

    static {
        Sort.instance = new InsertSorterImpl();
    }

    @Override
    public int[] sort(int[] unsorted) {
        for(int left = 0, min = 0; left < unsorted.length - 1; min = ++left) {
            for(int current = left + 1; current < unsorted.length; current++)
                if(unsorted[current] < unsorted[min]) {
                    min = current;
                }
            if(min != left) {
                swap(unsorted, left, min);
            }
        }
        int[] sorted = unsorted;
        return sorted;
    }

}
