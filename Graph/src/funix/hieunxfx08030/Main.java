package funix.hieunxfx08030;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.setEdge(0, 1);
        graph.setEdge(0, 2);
        graph.setEdge(2, 4);
        graph.setEdge(5, 6);
        graph.breadthFirstTraversal(0);
        System.out.println("=============");
        Boolean[] visitedArray = new Boolean[graph.getNumberOfVertices()];
        graph.depthFirstTraversalLogging(0, new Stack(graph.getNumberOfVertices()), visitedArray);
        System.out.println("=============");
        System.out.println("Number of group: " + graph.numberOfComponents());
    }
}
