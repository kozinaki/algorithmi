package net.kozinaki.algorithmi.sort;

public class InsertSorterImpl extends Sort {

    static {
        Sort.instance = new InsertSorterImpl();
    }

    @Override
    public int[] sort(int[] unsorted) {
        for(int i = 1, j = i, temp = 0; i < unsorted.length; j = ++i) {
            temp = unsorted[i];
            while(j > 0 && unsorted[j - 1] >= temp) {
                unsorted[j] = unsorted[j - 1];
                --j;
            }
            unsorted[j] = temp;
        }
        int[] sorted = unsorted;
        return sorted;
    }

}

