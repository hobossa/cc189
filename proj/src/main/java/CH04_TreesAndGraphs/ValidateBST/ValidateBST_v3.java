package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v3 {
    static Object lastElement = null;

    // solution from book
    // traverse the tree using an in-order traversal (left, current, right).
    // when it is go left child, the last node should not be greater than current node.
    // when it is go right child, the last node should not be equal to or greater than current node.

    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> root) {
        return isBSTInner(root, true);
    }

    public static <E extends Comparable<? super E>> boolean isBSTInner(BiTreeNode<E> node, boolean goLeft) {

        if (null == node) {
            return true;
        }

        // goLeft
        if (!isBSTInner(node.left, true)) {
            return false;
        }

        if (null != lastElement) {
            // System.out.println(lastElement + " " + goLeft + " " + node.element);
            if (goLeft) {
                // the lastNode is on my left child tree
                if (((E) lastElement).compareTo(node.element) > 0) {
                    return false;
                }
            } else {
                // the lastNode is my parent
                if (((E) lastElement).compareTo(node.element) >= 0) {
                    return false;
                }
            }
        }
        lastElement = node.element;

        if (!isBSTInner(node.right, false)) {
            return false;
        }

        return true;
    }
}
