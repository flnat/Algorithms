package sorting.HeapSort;

import sorting.GenericSortingAlgorithm;

import java.lang.reflect.Array;

public class Heap<Item extends Comparable<Item>> extends GenericSortingAlgorithm<Item> {
    private Item[] pq;
    private int n = 0;

    Heap(Class<Item> cls, int max) {
        // Safe cast --> therefore ok to suppress compiler warnings
        // see https://stackoverflow.com/a/18581313/14860000
        // tmp variable because of some strange behaviour
        // https://stackoverflow.com/a/7387796/14860000
        @SuppressWarnings("unchecked")
        Item[] tmp = (Item[]) Array.newInstance(cls, max);
        pq = tmp;
    }

    private Item max() {
        return pq[1];
    }

    public Item delMax() {
        Item max = max();
        exchange(1, n--);
        pq[n + 1] = null;
        sink(1);
        return max;

    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void insert(Item item) {
        pq[++n] = item;
        swim(n);
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exchange(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                exchange(k, j);
                k = j;
            }
        }
    }

    private void exchange(int k, int n) {
        Item tmp = pq[k];
        pq[k] = pq[n];
        pq[n] = tmp;
    }

    public Item[] sort() {
        // Da schon im Heap --> schon heapifiziert und dementsprechend nicht mehr
        // notwendig
        // int n = pq.length;
        // for (int k = n / 2; k >= 1; k--) {
        // sink(k);
        // }
        while (n > 1) {
            exchange(1, n--);
            sink(1);
        }
        return pq;
    }

}
