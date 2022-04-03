package CH10_SortingAndSearching.RankFromStream;


// similar to v1, but the count field in the node is the number
// of the node in the left child tree.
// this approach if from the book.

public class RankFromStream_v2 {
    private Node_v2 root;

    public void track(int x) {
        if (null == root) {
            root = new Node_v2(x);
        } else {
            root.insert(x);
        }
    }

    public int getRankOfNumber(int x) {
        return root != null ? root.getRank(x) : 0;
    }
}
