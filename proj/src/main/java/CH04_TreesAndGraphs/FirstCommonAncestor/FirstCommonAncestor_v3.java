package CH04_TreesAndGraphs.FirstCommonAncestor;

// In this algorithm, assume the node has no link to its parent.
// DFS approach.

import Common.BiTreeNode;

public class FirstCommonAncestor_v3 {
    private static class Result<E> {
        BiTreeNode<E> commonAncestor;
        boolean isContainNodeA;
        boolean isContainNodeB;

        public Result(BiTreeNode<E> ancestor, boolean isContainNodeA, boolean isContainNodeB) {
            this.commonAncestor = ancestor;
            this.isContainNodeA = isContainNodeA;
            this.isContainNodeB = isContainNodeB;
        }
    }

    public static <E> BiTreeNode<E> firstCommonAncestor(BiTreeNode<E> root, BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        Result<E> r = firstCommonAncestorInner(root, nodeA, nodeB);
        return r.commonAncestor;
    }

    public static <E> Result<E> firstCommonAncestorInner(BiTreeNode<E> node, BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        Result<E> result = new Result(null, false, false);
        if (null == node) return result;
        Result temp = firstCommonAncestorInner(node.left, nodeA, nodeB);
        if (temp.commonAncestor != null) {
            return temp;
        }
        if (temp.isContainNodeA) {
            result.isContainNodeA = true;
        }
        if (temp.isContainNodeB) {
            result.isContainNodeB = true;
        }

        temp = firstCommonAncestorInner(node.right, nodeA, nodeB);
        if (temp.commonAncestor != null) {
            return temp;
        }
        if (temp.isContainNodeA) {
            result.isContainNodeA = true;
        }
        if (temp.isContainNodeB) {
            result.isContainNodeB = true;
        }


        if (result.isContainNodeA && result.isContainNodeB) {
            result.commonAncestor = node;
        }

        if (node == nodeA) {
            result.isContainNodeA = true;
        }
        if (node == nodeB) {
            result.isContainNodeB = true;
        }

        return result;
    }
}
