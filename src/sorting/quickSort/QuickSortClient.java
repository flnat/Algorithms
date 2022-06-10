package sorting.quickSort;

public class QuickSortClient {
    public static void main(String[] args) {
        String tmp = "SortExample";
        String[] test = tmp.split("");
        QuickSort.<String>sort(test);
        QuickSort.<String>show(test);
    }
}
