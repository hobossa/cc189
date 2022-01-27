package CH04_TreesAndGraphs.CheckBalanced;

import Common.BiTreeNode;

public class CheckBalanced_v2 {

    public static <E> boolean isBalanced(BiTreeNode<E> root) {
        return isBalancedInner(root) >= 0;
    }

    // return the height of the node if it is balanced, else return -1
    private static <E> int isBalancedInner(BiTreeNode<E> node) {

        if (null == node) {
            //System.out.println("isBalancedInner null");
            return 0;
        }
        //System.out.println("isBalancedInner " + node.element.toString());
        int left = isBalancedInner(node.left);
        if (-1 == left) {
            return -1;
        }
        int right = isBalancedInner(node.right);
        if (-1 == right) {
            return -1;
        }
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
}
