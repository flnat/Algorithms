package sorting.HeapSort;

import sorting.ISort;

import java.util.LinkedHashMap;
import java.util.Map;

import static utils.ClientUtils.formatResults;
import static utils.ClientUtils.serializeResults;
import static utils.ClientUtils.threadedMeanRunTime;

public class HeapSortClient {
    public static void main(String[] args) {
        /*
         * Runtime Growth:
         * n:= 100.000 ~ 0.05s
         * n:= 1.000.000 ~ 0.3s
         * n:= 10.000.000 ~ 3.4s
         * n:= 100.000.000 ~ 50s
         */

        Map<Integer, Double> runTimeMapping = new LinkedHashMap<>();
        ISort<Integer> heapSort = new HeapSort<>(Integer.class);
        // Configure Testsizes
        for (int i = 1000; i <= 100000; i *= 10) {
            runTimeMapping.put(i, threadedMeanRunTime(heapSort, i, 5));
        }
        String formattedResults = formatResults(runTimeMapping);
        System.out.println(formattedResults);
        serializeResults(formattedResults, "out/HeapSort_Runtimes.txt");

    }

}
