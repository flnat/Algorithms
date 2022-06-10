package sorting.quickSort;

import static utils.ClientUtils.*;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickSortClient {
    // public static void main(String[] args) {
    // String tmp = "SortExample";
    // String[] test = tmp.split("");
    // QuickSort.<String>sort(test);
    // QuickSort.<String>show(test);
    // }

    public static void main(String[] args) {
        /*
         * Runtime Growth:
         * n:= 100.000 ~ 0.05s
         * n:= 1.000.000 ~ 0.3s
         * n:= 10.000.000 ~ 3.4s
         * n:= 100.000.000 ~ 50s
         */

        int n = 100_000;
        Integer[] array = makeArray(n);

        Stopwatch stopwatch = new Stopwatch();
        QuickSort.sort(array);
        System.out.printf("Elapsed time: %.2fs\n", stopwatch.elapsedTime());


    }

}
