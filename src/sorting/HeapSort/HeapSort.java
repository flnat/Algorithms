package sorting.HeapSort;

import java.lang.reflect.Array;

import sorting.GenericSortingAlgorithm;
import sorting.ISort;

public class HeapSort<Item extends Comparable<Item>> extends GenericSortingAlgorithm<Item> implements ISort<Item> {

    private Class<Item> typeName;

    public HeapSort(Class<Item> typeName) {
        this.typeName = typeName;
    }

    public void sort(Item[] items) {
        int n = items.length;

        @SuppressWarnings("unchecked")
        Item[] tmp = (Item[]) Array.newInstance(typeName, n + 1);
        System.arraycopy(items, 0, tmp, 1, items.length);
        // Heapfiy the Input
        for (int k = n / 2; k >= 1; k--) {
            sink(tmp, k, n);
        }
        int k = n;
        while (n > 1) {
            // Swap highest element to current last position of the pq, then move the
            // pointer one position up --> array outside of the pointer is sorted
            // --> behaviour is similar to delMax Method in MaxPriorityQueue Implementation
            exchange(tmp, 1, k--);
            // reheapify the input
            sink(tmp, 1, k);
        }
        System.arraycopy(tmp, 1, items, 0, tmp.length - 1);
    }

    // private static <Item extends Comparable<Item>> void swim(Item[] items, int k,
    // int n) {
    // while (k > 1 && less(k / 2, k)) {
    // exchange(items, k / 2, k);
    // k = k / 2;
    // }
    // }

    private static <Item extends Comparable<Item>> void sink(Item[] items, int k, int n) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exchange(items, k, j);
            k = j;
        }
    }
}