package CH09_SystemDesignAndScalability.Cache;

public class Node {
    private Node prev;
    private Node next;
    private String[] results;
    private String query;

    public Node(String query, String[] results) {
        this.results = results;
        this.query = query;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public String[] getResults() {
        return results;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
