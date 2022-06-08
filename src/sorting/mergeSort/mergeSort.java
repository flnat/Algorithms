package sorting.mergeSort;

import sorting.genericSorting;

public class mergeSort extends genericSorting {
    private static Comparable[] aux;

    public static <T extends Comparable<T>> void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        for (int k = 0; k <= high; k++) {
            aux[k] = a[k];
        }
        for (int k = low; k <= high; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > high)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];
        }
    }
}
