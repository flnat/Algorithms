package sorting.SelectionSort;


import sorting.GenericSortingAlgorithm;

public class SelectionSort extends GenericSortingAlgorithm {
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
