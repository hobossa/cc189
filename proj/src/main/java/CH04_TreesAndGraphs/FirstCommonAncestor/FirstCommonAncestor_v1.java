package CH04_TreesAndGraphs.FirstCommonAncestor;

import java.util.HashSet;

// In this algorithm, assume that every node has a link to its parent.

public class FirstCommonAncestor_v1 {
    // Does not meet "Avoid storing additional nodes in a data structure".
    // time O(depth)
    public static <E> TreeNode<E> firstCommonAncestor(TreeNode<E> nodeA, TreeNode<E> nodeB) {
        HashSet<TreeNode<E>> set = new HashSet<>();
        while (nodeA != null) {
            set.add(nodeA);
            nodeA = nodeA.parent;
        }

        while (nodeB != null) {
            if (set.contains(nodeB)) {
                break;
            }
            nodeB = nodeB.parent;
        }

        return nodeB;
    }
}
