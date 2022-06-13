package Graphs.data_scructures;

import data_structures.Bag;

public class Digraph {
    private final int vertices;
    private int edges;
    private Bag<DirectedEdge>[] adj;

    public Digraph(int vertices) {
        this.vertices = vertices;
        this.edges = 0;

        adj = (Bag<DirectedEdge>[]) new Bag[vertices];

        for (int v = 0; v < vertices; v++) {
            adj[v] = new Bag<DirectedEdge>();
        }
    }

    public int GetVertices() {
        return vertices;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.getFrom()].add(e);
        edges++;
    }

    public Iterable<DirectedEdge> adj(int vertex) {
        return adj[vertex];
    }

    public Iterable<DirectedEdge> getEdges() {
        Bag<DirectedEdge> bag = new Bag<>();
        for (int v = 0; v < vertices; v++) {
            for (DirectedEdge e : adj[v]) {
                bag.add(e);
            }
        }
        return bag;
    }

}
