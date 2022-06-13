package sorting;

public interface ISort<Item extends Comparable<Item>> {
    public void sort(Item[] a);
}
