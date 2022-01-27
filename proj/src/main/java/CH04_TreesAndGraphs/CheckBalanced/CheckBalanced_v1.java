package CH04_TreesAndGraphs.CheckBalanced;

import Common.BiTreeNode;

// brute force
// It's not efficient, because the height of subtrees are calculated many times.
public class CheckBalanced_v1 {
    public static <E> boolean isBalanced(BiTreeNode<E> root) {
        if (null == root) return true;
        return isBalanced(root.left)
                && isBalanced(root.right)
                && (Math.abs(height(root.left) - height(root.right)) <= 1);
    }

    private static <E> int height(BiTreeNode<E> root) {
        if (null == root) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
