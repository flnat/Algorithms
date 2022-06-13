package utils;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import sorting.ISort;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.lang.Math.log10;

public class ClientUtils {
    public static Integer[] makeArray(int n) {
        Integer[] array = new Integer[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.valueOf(i);
        }
        StdRandom.shuffle(array);
        return array;
    }

    public static double meanRunTime(ISort<Integer> sortingAlgorithm,
            int n) {
        // Calculate the mean of the runtime with a given input size after 5 samples
        double runTime = 0.0;
        int nSamples = 5;

        for (int i = 0; i < nSamples; i++) {
            Integer[] testData = makeArray(n);
            Stopwatch stopwatch = new Stopwatch();

            sortingAlgorithm.sort(testData);
            runTime += stopwatch.elapsedTime();
        }

        return runTime / nSamples;
    }

    public static double threadedMeanRunTime(ISort<Integer> sortingAlgorithm, int n, int times) {
        List<Double> runTimes = new ArrayList<>();
        List<Thread> threads = new LinkedList<>();
        Runnable runnable = new Runnable() {
            public void run() {
                runTimes.add(singleRuntime(sortingAlgorithm, n));
            }
        };

        for (int i = 0; i < times; i++) {
            threads.add(new Thread(runnable));
            threads.get(i).start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                continue;
            }
        }

        return runTimes
                .stream()
                .collect(
                        Collectors.averagingDouble(x -> x));
    }

    private static double singleRuntime(ISort<Integer> sortingAlgorithm, int n) {
        Integer[] testData = makeArray(n);
        Stopwatch stopwatch = new Stopwatch();
        sortingAlgorithm.sort(testData);
        return stopwatch.elapsedTime();
    }

    public static String formatResults(Map<Integer, Double> runTimeMapping) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("n\t\t|Time in seconds\n");
        stringBuilder.append("-".repeat(15));
        stringBuilder.append("\n");
        for (Entry<Integer, Double> entry : runTimeMapping.entrySet()) {
            stringBuilder.append(
                    String.format("%s\t|%.2f\n",
                            formatScientific(entry.getKey()),
                            entry.getValue()));
        }

        return stringBuilder.toString();

    }

    private static String formatScientific(int n) {
        return String.format("10e%d", (int) log10((double) n));
    }

    public static void serializeResults(String results, String relativePath) {
        Path path = Paths.get(relativePath);

        try {
            Files.writeString(
                    path,
                    results);
        } catch (IOException e) {
            String pathRepresentation = path.toString();
            System.err.printf("Unable to write results to file. Please ensure that the directory %s is writeable\n",
                    pathRepresentation.substring(0, pathRepresentation.lastIndexOf(File.separator)));
        }
    }
}
