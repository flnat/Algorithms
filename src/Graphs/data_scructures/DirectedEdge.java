package Graphs.data_scructures;

public class DirectedEdge implements Comparable<DirectedEdge> {
    private final int v;
    private final int w;
    private final double weight;

    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int getFrom() {
        return v;
    }

    public int getTo() {
        return w;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return String.format("%d->%d %.2f", v, w, weight);
    }

    @Override
    public int compareTo(DirectedEdge e) {
        if (this.weight > e.weight) {
            return 1;
        } else if (this.weight < e.weight) {
            return -1;
        } else {
            return 0;
        }
    }

}
