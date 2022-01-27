package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

// brute force: check every value in the left <= node. and every value in the right > node.
public class ValidateBST_v1 {
    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> root) {
        if (null == root) {
            return true;
        }

        return checkSub(root.left, root.element, true)
                && checkSub(root.right, root.element, false)
                && isBST(root.left)
                && isBST(root.right);
    }

    private static <E extends Comparable<? super E>> boolean checkSub(BiTreeNode<E> node, E element, boolean isLeft) {
        if (null == node) {
            return true;
        }
        if (isLeft) {
            if (node.element.compareTo(element) > 0) {
                return false;
            }
        } else {
            if (node.element.compareTo(element) <= 0) {
                return false;
            }
        }

        return checkSub(node.left, element, isLeft) && checkSub(node.right, element, isLeft);
    }

}
