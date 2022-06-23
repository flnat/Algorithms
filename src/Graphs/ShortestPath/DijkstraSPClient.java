package Graphs.ShortestPath;

import Graphs.data_scructures.Digraph;
import Graphs.data_scructures.DirectedEdge;

public class DijkstraSPClient {
    public static void main(String[] args) {
        Digraph graph = new Digraph(6);
        graph.addEdge(new DirectedEdge(0, 1, 4));
        graph.addEdge(new DirectedEdge(0, 2, 4));
        graph.addEdge(new DirectedEdge(1, 3, 4));
        graph.addEdge(new DirectedEdge(1, 4, 5));
        graph.addEdge(new DirectedEdge(2, 4, 5));
        graph.addEdge(new DirectedEdge(3, 4, 2));
        graph.addEdge(new DirectedEdge(3, 5, 5));
        graph.addEdge(new DirectedEdge(4, 5, 3));


        DijkstraSP sp = new DijkstraSP(graph, 0);
        System.out.printf("Die kürzeste Strecke zwischen den Knoten 0 --> 5 ist %.2f\n",sp.distTo(5));
        System.out.printf("Es wird dabei folgender Pfad beschritten: " +  sp.pathTo(5));


    }
}
