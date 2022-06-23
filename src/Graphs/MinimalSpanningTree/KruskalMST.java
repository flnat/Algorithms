package Graphs.MinimalSpanningTree;

import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.EdgeWeightedGraph;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class KruskalMST {
    private Queue<Edge> mst;

    public KruskalMST(EdgeWeightedGraph G){
        mst = new Queue<>();
        MinPQ<Edge> pq = new MinPQ<Edge>();
    }


}
