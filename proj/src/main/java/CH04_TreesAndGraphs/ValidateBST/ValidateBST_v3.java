package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v3 {
    static Object lastElement = null;
    static int lastElementDepth = 0;

    // solution from book
    // traverse the tree using an in-order traversal (left, current, right).
    // there are two scenarios continuously alternating here. Using a static int variable to record the last element's depth.
    // 1, the last Element is on the current node's left child tree.
    //    the last element' depth should greater than current depth
    //    the last element should not be greater than the current
    // 2. current element is on the last Element's right child tree.
    //    the last element's depth should smaller than current depth.
    //    the last element should not be greater than or equal to the current

    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> node) {
        lastElement = null;
        lastElementDepth = 0;
        return isBST(node, 0);
    }

    @SuppressWarnings("unchecked")
    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> node, int depth) {
        if (null == node) {
            return true;
        }

        // goLeft
        if (!isBST(node.left, depth+1)) {
            return false;
        }

        if (null != lastElement) {
            // System.out.println(lastElement + " " + goLeft + " " + node.element);
            if (lastElementDepth > depth) {
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
        }
        lastElement = node.element;
        lastElementDepth = depth;

        if (!isBST(node.right, depth+1)) {
            return false;
        }

        return true;
    }
}
