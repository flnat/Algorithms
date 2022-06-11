package sorting.InsertionSort;

import sorting.ISort;

import java.util.LinkedHashMap;
import java.util.Map;
 
import static utils.ClientUtils.formatResults;
import static utils.ClientUtils.serializeResults;
import static utils.ClientUtils.threadedMeanRunTime;

public class InsertionSortClient {
    public static void main(String[] args) {
        Map<Integer, Double> runTimeMapping = new LinkedHashMap<>();
        ISort<Integer> insertionSort = new InsertionSort<>();
        // Configure Testsizes
        for (int i = 1000; i <= 1_000_000; i *= 10) {
            runTimeMapping.put(i, threadedMeanRunTime(insertionSort, i, 5));
        }
        String formattedResults = formatResults(runTimeMapping);
        System.out.println(formattedResults);
        serializeResults(formattedResults, "out/InsertionSort_Runtimes.txt");

    }
}
