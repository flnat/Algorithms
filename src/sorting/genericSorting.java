package sorting;

public abstract class genericSorting {

    protected static <T extends Comparable<T>> void exchange(T[] arr, int first, int second) {
        T temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    protected static <T extends Comparable<T>> boolean less(T a, T b) {
        return a.compareTo(b) < 0;
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

}
