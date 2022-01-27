package CH04_TreesAndGraphs.RouteBetweenNodes;

import java.util.ArrayList;
import java.util.Queue;

public class RouteBetweenNodes_v1 {

    // Brute force. this is a directed graph, so Bidirectional Search is not applicable.
    public static <E extends Comparable<? super E>> boolean search(Graph<E> graph, Vertex<E> start, Vertex<E> end) {
        // use ArrayList as a queue
        boolean ret = false;
        ArrayList<Vertex<E>> queue = new ArrayList<>();
        queue.add(start);
        start.setMarked(true);
        while (!queue.isEmpty()){
            Vertex<E> v = queue.remove(0);
            if(0 == v.getElement().compareTo(end.getElement())) {
                ret = true;
                break;
            }
            v.getAdjacent().forEach((i) -> {
                if (!i.isMarked()) {queue.add(i);
                    i.setMarked(true);
                }
            });
        }

        return ret;
    }

}
