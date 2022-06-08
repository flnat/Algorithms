package sorting.selectionSort;


import sorting.genericSorting;

public class selectionSort extends genericSorting {
    public static <T extends Comparable<T>> void sort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(arr[j], arr[min])) {
                    min = j;
                }
            }
            exchange(arr, i, min);
        }
    }
}
