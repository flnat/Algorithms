package utils;

import edu.princeton.cs.algs4.StdRandom;

public class ClientUtils {
    public static Integer[] makeArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(i);
        }
        StdRandom.shuffle(array);
        return array;
    }
}
