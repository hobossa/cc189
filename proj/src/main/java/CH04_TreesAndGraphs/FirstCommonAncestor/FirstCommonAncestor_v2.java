package CH04_TreesAndGraphs.FirstCommonAncestor;

import Common.BiTreeNode;

// In this algorithm, assume that every node has a link to its parent.
public class FirstCommonAncestor_v2 {

    // time O(depth).
    public static <E> BiTreeNode<E> firstCommonAncestor(BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        int depthA = depth(nodeA);
        int depthB = depth(nodeB);
        if (depthA > depthB) {
            nodeA = preAncestor(nodeA, depthA - depthB + 1);
            nodeB = nodeB.parent;
        } else {
            nodeB = preAncestor(nodeB, depthB- depthA + 1);
            nodeA = nodeA.parent;
        }
        while (nodeA != nodeB) {
            nodeA = nodeA.parent;
            nodeB = nodeB.parent;
        }
        return nodeA;
    }

    private static <E> int depth(BiTreeNode<E> node) {
        int n = 0;
        while (node != null) {
            n++;
            node = node.parent;
        }
        return n;
    }

    private static <E> BiTreeNode<E> preAncestor(BiTreeNode<E> node, int n) {
        while (n-- > 0) {
            node = node.parent;
        }
        return node;
    }
}
