package net.kozinaki.algorithmi.find;

import java.util.Arrays;

public class Mediana {

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++)
            array[i] = ((int)(Math.random() * size) + 1);
        System.out.println(Arrays.toString(array));
        getMediana(array);
        sort(array);
        System.out.println(Arrays.toString(array));
    }   

    private static int getMediana(int[] array) {
        int le = 0, eq = 0;
        int aim = array.length / 2;
        int mediana1 = -1, mediana2 = -1;
        boolean key = true;
        if(array.length % 2 != 0) {
            aim++;
            key = false;
        }
        System.out.println("aim - " + aim);
        for(int i = 0, j = 0; i < array.length; i++) {
            le = 0; eq = 0;
            while(le <= aim && eq <= aim && j < array.length) {
                if(array[i] > array[j])
                    le++;
                else if(array[i] == array[j])
                    eq++;
                j++;
            }
            j = 0;
            System.out.println(array[i] + ": " + le + " " + eq);
            if(le <= (aim - 1) && (le + eq) >= aim) {
                mediana1 = array[i];
            }
            if(key && le <= aim && (le + eq) > aim) {
                mediana2 = array[i];
            }
            if(!key && mediana1 != -1) {
                System.out.println(mediana1);
                return 0;
            } else if(mediana1 != -1 && mediana2 != -1) {
                System.out.println((mediana1 + mediana2) / 2.0);
                return 0;
            }
        }
        return 0;   
    } 
    
    public static void sort(int[] array) {
        for(int i = array.length - 1; i > 0; i--)
            for(int j = 0; j < i; j++)
                if(array[j] > array[j + 1]) {
                    array[j + 1] += array[j];
                    array[j] = array[j + 1] - array[j];
                    array[j + 1] -= array[j];
                }
    }

}
