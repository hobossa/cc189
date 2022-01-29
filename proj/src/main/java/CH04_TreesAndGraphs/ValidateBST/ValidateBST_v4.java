package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v4 {
    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> root) {
        return checkRange(root, null, null);
    }

    // to check if every node in the tree is greater than minElement and less than or equal to MaxElement. (min, Max]
    private static <E extends Comparable<? super E>> boolean checkRange(BiTreeNode<E> node, E minElement, E maxElement) {
        if (null == node) {
            return true;
        }
        if (null != minElement && node.element.compareTo(minElement) <= 0) {
            return false;
        }
        if (null != maxElement && node.element.compareTo(maxElement) > 0) {
            return false;
        }
        return checkRange(node.left, minElement, node.element) &&
                checkRange(node.right, node.element, maxElement);
    }
}
