package CH09_SystemDesignAndScalability.Cache;

import java.util.HashMap;

public class Cache {
    private static final int MAX_SIZE = 10;
    private Node head, tail;
    private HashMap<String, Node> map;
    private int size = 0;

    public Cache() {
        this.map = new HashMap<>();
    }

    // moves node to front fo linked list
    public void moveToFront(Node node) {
        if (node == head) return;

        removeFromLinkedList(node);
        node.setNext(head);
        if (head != null) {
            head.setPrev(node);
        }
        head = node;
        size++;
        if (tail == null) {
            tail = node;
        }
    }

    public void moveToFront(String query) {
        Node node = map.get(query);
        moveToFront(node);
    }

    // Remove node from linked list
    public void removeFromLinkedList(Node node) {

    }

    // Get results from cache, and updates linked list
    public String[] getResults(String query) {
        if (!map.containsKey(query)) return null;

        Node node = map.get(query);
        moveToFront(node);
        return node.getResults();
    }

    // Insert results into linked list and hash
    public void insertResults(String query, String[] results) {
        if (map.containsKey(query)) {
            // update results
            Node node = map.get(query);
            node.setResults(results);
            moveToFront(node);  // update freshness
            return;
        }

        Node node = new Node(query, results);
        moveToFront(node);
        map.put(query, node);

        if (size > MAX_SIZE) {
            map.remove(tail.getQuery());
            removeFromLinkedList(tail);
        }
    }
}
