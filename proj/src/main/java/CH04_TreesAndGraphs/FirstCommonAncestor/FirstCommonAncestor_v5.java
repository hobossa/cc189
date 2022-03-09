package CH04_TreesAndGraphs.FirstCommonAncestor;

import Common.BiTreeNode;

public class FirstCommonAncestor_v5 {
    public static <E> BiTreeNode<E> firstCommonAncestor(BiTreeNode<E> root, BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        if (root == nodeA || root == nodeB || root == null) {
            return root;
        }
        BiTreeNode<E> left = firstCommonAncestor(root.left, nodeA, nodeB);
        BiTreeNode<E> right = firstCommonAncestor(root.right, nodeA, nodeB);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}
