package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v3 {
    static Object lastElement = null;
    static boolean isLastElementInLeftChildTree = true;

    // solution from book
    // traverse the tree using an in-order traversal (left, current, right).
    // there are two scenarios continuously alternating here.
    // 1, the last Element is on the current node's left child tree.
    //    the last element should not be greater than the current
    // 2. current element is on the last Element's right child tree.
    //    the last element should not be greater than or equal to the curren


    @SuppressWarnings("unchecked")
    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> node) {

        if (null == node) {
            return true;
        }

        // goLeft
        if (!isBST(node.left)) {
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

        if (!isBST(node.right)) {
            return false;
        }

        return true;
    }
}
