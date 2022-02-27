package CH04_TreesAndGraphs.CheckSubtree;

import Common.BiTreeNode;

public class CheckSubTree_v1 {
    public static <E> boolean isSubTree(BiTreeNode<E> tree, BiTreeNode<E> sub) {
        if (tree != null && sub != null) {
            if (isEqual(tree, sub)) {
                return true;
            }
            return isSubTree(tree.left, sub) || isSubTree(tree.right, sub);
        } else if (tree != null || sub != null) {
            return false;
        } else {
            // both are null
            return true;
        }

    }

    private static <E> boolean isEqual(BiTreeNode<E> t1, BiTreeNode<E> t2) {
        if (t1 != null && t2 != null) {
            if (!t1.element.equals(t2.element)) {
                return false;
            }
            return isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
        } else if (t1 != null || t2 != null) {
            return false;
        } else {
            // both are null
            return true;
        }
    }
}
