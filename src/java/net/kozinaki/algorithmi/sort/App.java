package net.kozinaki.algorithmi.sort;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        BubbleSorterImpl bubbleSorter = new BubbleSorterImpl();
        random(bubbleSorter, size);
        unsorted(bubbleSorter, size);
        sorted(bubbleSorter, size);

        System.out.println("---------------");
        
        SelectSorterImpl simpleSorter = new SelectSorterImpl();
        random(simpleSorter, size);
        unsorted(simpleSorter, size);
        sorted(simpleSorter, size);

        System.out.println("---------------");

        InsertSorterImpl insertSorter = new InsertSorterImpl();
        random(insertSorter, size);
        unsorted(insertSorter, size);
        sorted(insertSorter, size);

    }

    public static void random(Sorter sorter, int size) {
        int[] src = new int[size];
        for(int i = 0; i < src.length; i++)
            src[i] = (int)(Math.random() * size + 1);
        System.out.println("random");
        if(size < 28) 
            System.out.println(" - " + Arrays.toString(src));
        long time = System.currentTimeMillis();
        sorter.sort(src);
        time = System.currentTimeMillis() - time;
        if(size < 28)
            System.out.println(" - " + Arrays.toString(src));
        System.out.println(" - " + (time / 1000.0));
    }

    public static void unsorted(Sorter sorter, int size) {
        int[] src = new int[size];
        for(int i = 0; i < src.length; i++)
            src[i] =  src.length - i;
        System.out.println("unsorted");
        if(size < 28) 
            System.out.println(" - " + Arrays.toString(src));
        long time = System.currentTimeMillis();
        sorter.sort(src);
        time = System.currentTimeMillis() - time;
        if(size < 28)
            System.out.println(" - " + Arrays.toString(src));
        System.out.println(" - " + (time / 1000.0));
    }

    public static void sorted(Sorter sorter, int size) {
        int[] src = new int[size];
        for(int i = 0; i < src.length; i++)
            src[i] =  i + 1;
        System.out.println("sorted");
        if(size < 28) 
            System.out.println(" - " + Arrays.toString(src));
        long time = System.currentTimeMillis();
        sorter.sort(src);
        time = System.currentTimeMillis() - time;
        if(size < 28)
            System.out.println(" - " + Arrays.toString(src));
        System.out.println(" - " + (time / 1000.0));
    }

}
