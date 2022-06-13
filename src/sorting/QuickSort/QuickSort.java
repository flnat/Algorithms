package sorting.QuickSort;

import sorting.GenericSortingAlgorithm;
import sorting.ISort;

public class QuickSort<Item extends Comparable<Item>> extends GenericSortingAlgorithm<Item> implements ISort<Item> {
    @Override
    public void sort(Item[] a) {
        sort(a, 0, a.length - 1);
    }

    private static <Item extends Comparable<Item>> void sort(Item[] a, int low, int high) {
        // Breche bei elementaren Teillisten ab
        if (high <= low) {
            return;
        }
        // Trenne in zwei teillisten auf
        int j = partition(a, low, high);
        sort(a, low, j - 1);
        sort(a, j + 1, high);
    }

    private static <Item extends Comparable<Item>> int partition(Item[] a, int low, int high) {
        // Initialisierung der Pointer
        int i = low;
        int j = high + 1;
        // Pivotelemement an erster Position --> naiv
        Item pivotElement = a[low];
        while (true) {
            // Inkrementiere den i Pointer, solange a[i] < pivotElement
            while (less(a[++i], pivotElement)) {
                if (i == high) {
                    break;
                }
            }
            // Inkrementiere den j Pointer, solange a[j] > pivotElement
            while (less(pivotElement, a[--j])) {
                if (j == low) {
                    break;
                }
            }
            // Wenn sich Pointer Kreuzen breche ab
            if (i >= j) {
                break;
            }
            // Tausche Werte zwischen i und j Pointern
            exchange(a, i, j);
        }
        // Tausche Pivotelement mit momenater Position des j Pointers
        exchange(a, low, j);
        return j;
    }

}
