package CH04_TreesAndGraphs.RouteBetweenNodes;

import java.util.ArrayList;

public class Vertex<E extends Comparable<? super E>> {
    private final E element;
    private final ArrayList<Vertex<E>> adjacent;
    private boolean marked;

    public Vertex(E element) {
        this.element = element;
        this.adjacent = new ArrayList<>();
        this.marked = false;
    }

    public void addAdjacent(Vertex x) {
        adjacent.add(x);
    }

    public ArrayList<Vertex<E>> getAdjacent() {
        return adjacent;
    }

    public int getAdjacentCount() {
        return adjacent.size();
    }

    public E getElement() {
        return element;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(element.toString());
        stringBuilder.append(" ->");
        adjacent.forEach((i) -> stringBuilder.append(" " + i.element.toString()));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
