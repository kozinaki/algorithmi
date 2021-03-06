package net.kozinaki.fundamenta.algorithm.find;

public class LinearSearch implements Search {

    @Override
    public int search(int[] data, int value) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return -1;
    }

}
