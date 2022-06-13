package sorting.MergeSort;

import static utils.ClientUtils.*;
import edu.princeton.cs.algs4.Stopwatch;

public class MergeSortClient {
    public static void main(String[] args) {
        /*
         * Runtime Growth:
         * n:= 100.000 ~ 0.12s
         * n:= 1.000.000 ~ 0.75s
         * n:= 10.000.000 ~ 9.12s
         * n:= 100.000.000 ~ 146s
         */

        int n = 100_000_000;
        Integer[] array = makeArray(n);

        Stopwatch stopwatch = new Stopwatch();
        MergeSort.sort(array);
        System.out.printf("Elapsed time: %.2fs\n", stopwatch.elapsedTime());

    }
}
