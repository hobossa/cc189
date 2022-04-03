package CH10_SortingAndSearching.RankFromStream;


// using a BST as the data structure.
// here we simulate it with a normal BST.
// For better performance we should use a more balance binary search tree, such as a RED_BLACK TREE
public class RankFromStream_v1 {
    private Node_v1 root;

    public void track(int x) {
        root = insert(root, x);
    }

    public int getRankOfNumber(int x) {
        Node_v1 temp = getMinNodeGreaterOrEqualX(root, x);
        return getRankOfNumber(temp);
    }

    private Node_v1 insert(Node_v1 node, int x) {
        if (null == node) {
            return new Node_v1(x);
        }
        node.count++;
        if (x <= node.value) {
            node.left = insert(node.left, x);
            node.left.parent = node;
        } else {    // x > node.value
            node.right = insert(node.right, x);
            node.right.parent = node;
        }
        return node;
    }

    // get the node that value equals x or the smallest value greater than x
    private Node_v1 getMinNodeGreaterOrEqualX(Node_v1 node, int x) {

        if (node.value == x) {
            return node;
        } else if (x < node.value) {
            if (node.left == null) {
                return node;
            } else {
                return getMinNodeGreaterOrEqualX(node.left, x);
            }
        } else {    // x > node.value
            if (node.right == null) {
                while (node.parent != null) {
                    if (node == node.parent.left) {
                        break;
                    }
                    node = node.parent;
                }
                return node.parent;
            } else {
                return getMinNodeGreaterOrEqualX(node.right, x);
            }
        }
    }

    private int getRankOfNumber(Node_v1 node) {
        if (null == node) {
            return root.count;
        }

        int num = 0;
        if (node.left != null) {
            num += node.left.count;
        }

        while (node.parent != null) {
            if (node == node.parent.right) {
                // node is the right child
                num = num + 1 + (node.parent.left != null ? node.parent.left.count : 0);
            } else {
                // node is the left child
            }
            node = node.parent;
        }
        return num;
    }
}
