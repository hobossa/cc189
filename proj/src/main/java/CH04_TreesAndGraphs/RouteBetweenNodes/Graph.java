package CH04_TreesAndGraphs.RouteBetweenNodes;

import java.util.ArrayList;

public class Graph<E extends Comparable<? super E>> {
    private final ArrayList<Vertex<E>> vertexes;

    public Graph() {
        this.vertexes = new ArrayList<>();
    }

    public void addVertex(Vertex<E> x) {
        vertexes.add(x);
    }

    public ArrayList<Vertex<E>> getVertexes() {
        return vertexes;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        vertexes.forEach((v) -> stringBuilder.append(v.toString()));
        return stringBuilder.toString();
    }
}
