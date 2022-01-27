package CH04_TreesAndGraphs.CheckBalanced;

import Common.BiTreeNode;

// brute force
// It's not efficient, because the height of subtrees are calculated many times.
public class CheckBalanced_v1 {
    public static <E> boolean isBalanced(BiTreeNode<E> root) {
        //System.out.println("isBalanced");
        if (null == root) return true;
        return isBalanced(root.left)
                && isBalanced(root.right)
                && (Math.abs(height(root.left) - height(root.right)) <= 1);
    }

    private static <E> int height(BiTreeNode<E> node) {

        if (null == node) {
            //System.out.println("height null");
            return 0;
        }
        //System.out.println("height " + node.element.toString());
        return 1 + Math.max(height(node.left), height(node.right));
    }
}
