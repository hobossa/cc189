package CH04_TreesAndGraphs.FirstCommonAncestor;

// In this algorithm, assume the node has no link to its parent.
// DFS approach.

public class FirstCommonAncestor_v3 {
    private static class Result<E> {
        TreeNode<E> commonAncestor;
        boolean isContainNodeA;
        boolean isContainNodeB;

        public Result(TreeNode<E> ancestor, boolean isContainNodeA, boolean isContainNodeB) {
            this.commonAncestor = ancestor;
            this.isContainNodeA = isContainNodeA;
            this.isContainNodeB = isContainNodeB;
        }
    }

    public static <E> TreeNode<E> firstCommonAncestor(TreeNode<E> root, TreeNode<E> nodeA, TreeNode<E> nodeB) {
        Result<E> r = firstCommonAncestorInner(root, nodeA, nodeB);
        return r.commonAncestor;
    }

    public static <E> Result<E> firstCommonAncestorInner(TreeNode<E> node, TreeNode<E> nodeA, TreeNode<E> nodeB) {
        Result<E> result = new Result(null, false, false);

        for (TreeNode<E> child : node.getChildren()) {
            if (result.isContainNodeA && result.isContainNodeB) {
                break;
            }
            Result temp = firstCommonAncestorInner(child, nodeA, nodeB);
            if (temp.commonAncestor != null) {
                return temp;
            }
            if (temp.isContainNodeA) {
                result.isContainNodeA = true;
            }
            if (temp.isContainNodeB) {
                result.isContainNodeB = true;
            }
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
