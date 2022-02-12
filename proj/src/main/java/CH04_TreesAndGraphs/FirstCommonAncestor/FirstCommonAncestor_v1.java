package CH04_TreesAndGraphs.FirstCommonAncestor;

import Common.BiTreeNode;

import java.util.HashSet;

// In this algorithm, assume that every node has a link to its parent.

public class FirstCommonAncestor_v1 {
    // Does not meet "Avoid storing additional nodes in a data structure".
    // time O(depth)
    public static <E> BiTreeNode<E> firstCommonAncestor(BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        HashSet<BiTreeNode<E>> set = new HashSet<>();
        nodeA = nodeA.parent;
        while (nodeA != null) {
            set.add(nodeA);
            nodeA = nodeA.parent;
        }

        nodeB = nodeB.parent;
        while (nodeB != null) {
            if (set.contains(nodeB)) {
                break;
            }
            nodeB = nodeB.parent;
        }

        return nodeB;
    }
}
