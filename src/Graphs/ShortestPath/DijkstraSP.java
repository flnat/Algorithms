package Graphs.ShortestPath;

import Graphs.data_scructures.Digraph;
import Graphs.data_scructures.DirectedEdge;
import Graphs.data_scructures.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(Digraph g, int s) {
        edgeTo = new DirectedEdge[g.GetVertices()];
        distTo = new double[g.GetVertices()];
        pq = new IndexMinPQ<>(g.GetVertices());

        for (int v = 0; v < g.GetVertices(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(g, pq.delMin());
        }
    }

    private void relax(Digraph g, int v) {
        for (DirectedEdge e : g.adj(v)) {
            int w = e.getTo();
            if (distTo[w] > distTo[v] + e.getWeight()) {
                distTo[w] = distTo[v] + e.getWeight();
                edgeTo[w] = e;
                if (pq.contains(w)) {
                    pq.changeKey(w, distTo[w]);
                } else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.getFrom()]) {
            path.push(e);
        }
        return path;
    }

}
