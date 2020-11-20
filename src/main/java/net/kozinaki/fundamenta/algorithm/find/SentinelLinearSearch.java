package net.kozinaki.fundamenta.algorithm.find;

public class SentinelLinearSearch implements Search {

    @Override
    public int search(int[] data, int value) {
        int last = data[data.length - 1];
        data[data.length - 1] = value;
        int i = 1;
        while (data[i] != value) {
            i++;
        }
        data[data.length - 1] = last;
        if (i < data.length - 1 || data[data.length - 1] == value) {
            return i;
        }
        return -1;
    }

}
