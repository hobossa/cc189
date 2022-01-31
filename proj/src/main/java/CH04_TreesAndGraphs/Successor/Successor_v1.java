package CH04_TreesAndGraphs.Successor;

import Common.BiTreeNode;

public class Successor_v1 {
    public static <E extends Comparable<? super E>> BiTreeNode<E> getSuccessor(BiTreeNode<E> node) {
        if (null == node) {
            return null;
        }

        BiTreeNode<E> successor = null;

        // if it has right child, get the successor in the right child tree.
        if (null != node.right) {
            successor = node.right;
            while (null != successor.left) {
                successor = successor.left;
            }
            return successor;
        }

        // find the successor in its ancestor nodes
        boolean bFound = false;
        while (null != node.parent) {
            if (node == node.parent.left) {
                bFound = true;
                successor = node.parent;
                break;
            }
            node = node.parent;
        }

        if (bFound) {
            return successor;
        }

        return null;
    }
}
