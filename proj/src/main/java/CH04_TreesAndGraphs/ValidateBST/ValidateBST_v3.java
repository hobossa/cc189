package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v3 {
    static Object lastElement = null;
    static boolean isLastElementInLeftChildTree = true;

    // solution from book
    // traverse the tree using an in-order traversal (left, current, right).
    // when it is go left child, the last node should not be greater than current node.
    // when it is go right child, the last node should not be equal to or greater than current node.

    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> root) {
        return isBSTInner(root);
    }

    public static <E extends Comparable<? super E>> boolean isBSTInner(BiTreeNode<E> node) {

        if (null == node) {
            return true;
        }

        // goLeft
        if (!isBSTInner(node.left)) {
            return false;
        }

        if (null != lastElement) {
            // System.out.println(lastElement + " " + goLeft + " " + node.element);
            if (isLastElementInLeftChildTree) {
                // the lastNode is on current node's left child tree
                if (((E) lastElement).compareTo(node.element) > 0) {
                    return false;
                }
            } else {
                // current node is on the last Element's right child tree.
                if (((E) lastElement).compareTo(node.element) >= 0) {
                    return false;
                }
            }
            isLastElementInLeftChildTree = !isLastElementInLeftChildTree;
        }
        lastElement = node.element;

        if (!isBSTInner(node.right)) {
            return false;
        }

        return true;
    }
}
