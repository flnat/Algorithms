package sorting.InsertionSort;

import sorting.GenericSortingAlgorithm;
import sorting.ISort;

public class InsertionSort<Item extends Comparable<Item>> extends GenericSortingAlgorithm<Item> implements ISort<Item> {

    @Override
    public void sort(Item[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }

}
