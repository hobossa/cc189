package CH10_SortingAndSearching.RankFromStream;

public class Node_v1 {
    int value;
    int count;
    Node_v1 parent;
    Node_v1 left;
    Node_v1 right;

    public Node_v1(int value) {
        this.value = value;
        this.count = 1;
    }
}
