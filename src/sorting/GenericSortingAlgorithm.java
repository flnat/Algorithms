package sorting;

public abstract class GenericSortingAlgorithm<Item extends Comparable<Item>> {

    protected static <T extends Comparable<T>> void exchange(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    protected static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
    }

    protected static <T extends Comparable<T>> boolean greater(T a, T b) {
        return a.compareTo(b) > 0;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(arr[i - 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <T extends Comparable<T>> void show(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d: %s\n", i, arr[i]);
        }
    }

    public static <T extends Comparable<T>> int medianOfThree(T[] arr) {

        int lowIdx = 0;
        int highIdx = arr.length;
        int midIdx = arr.length / 2;

        T low = arr[lowIdx];
        T high = arr[highIdx];
        T mid = arr[midIdx];

        if (low.compareTo(mid) > 0 ^ low.compareTo(high) > 0) {
            return lowIdx;
        } else if (mid.compareTo(low) < 0 ^ mid.compareTo(high) < 0) {
            return midIdx;
        } else {
            return highIdx;
        }
    }

}
