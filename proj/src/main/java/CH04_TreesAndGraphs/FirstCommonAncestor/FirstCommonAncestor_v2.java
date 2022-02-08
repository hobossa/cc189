package CH04_TreesAndGraphs.FirstCommonAncestor;

// In this algorithm, assume that every node has a link to its parent.
public class FirstCommonAncestor_v2 {

    // time O(depth).
    public static <E> TreeNode<E> firstCommonAncestor(TreeNode<E> nodeA, TreeNode<E> nodeB) {
        int depthA = depth(nodeA);
        int depthB = depth(nodeB);
        if (depthA > depthB) {
            nodeA = preAncestor(nodeA, depthA - depthB);
        } else {
            nodeB = preAncestor(nodeB, depthB- depthA);
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.parent;
            nodeB = nodeB.parent;
        }
        return nodeA;
    }

    private static <E> int depth(TreeNode<E> node) {
        int n = 0;
        while (node != null) {
            n++;
            node = node.parent;
        }
        return n;
    }

    private static <E> TreeNode<E> preAncestor(TreeNode<E> node, int n) {
        while (n-- > 0) {
            node = node.parent;
        }
        return node;
    }
}
