package CH04_TreesAndGraphs.RouteBetweenNodes;

// Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
// Hints: #127

import java.util.ArrayList;

public class RouteBetweenNodesTest {

    @SuppressWarnings("unchecked")
    public static Graph<String> createTestGraph() {
        Vertex[] vertices = new Vertex[6];
        vertices[0] = new Vertex<String>("a");
        vertices[1] = new Vertex<String>("b");
        vertices[2] = new Vertex<String>("c");
        vertices[3] = new Vertex<String>("d");
        vertices[4] = new Vertex<String>("e");
        vertices[5] = new Vertex<String>("f");

        vertices[0].addAdjacent(vertices[1]);
        vertices[0].addAdjacent(vertices[2]);
        vertices[0].addAdjacent(vertices[3]);
        vertices[3].addAdjacent(vertices[4]);
        vertices[4].addAdjacent(vertices[5]);

        Graph<String> graph = new Graph<>();
        for (int i = 0; i < 6; i++) {
            graph.addVertex(vertices[i]);
        }
        return graph;
    }

    public static void main(String[] args) {
        Graph<String> graph = createTestGraph();
        System.out.println(graph);
        ArrayList<Vertex<String>> vertexes = graph.getVertexes();
        Vertex<String> start = vertexes.get(1);
        Vertex<String> end = vertexes.get(5);
        System.out.println(RouteBetweenNodes_v1.search(graph, start, end));
    }
}
