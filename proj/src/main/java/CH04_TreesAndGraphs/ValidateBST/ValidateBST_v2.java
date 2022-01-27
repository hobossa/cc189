package CH04_TreesAndGraphs.ValidateBST;

import Common.BiTreeNode;

public class ValidateBST_v2 {
    private static class Result<E> {
        boolean isBST;
        E minElement;
        E maxElement;

        public Result(boolean isBST, E minElement, E maxElement) {
            this.isBST = isBST;
            this.minElement = minElement;
            this.maxElement = maxElement;
        }
    }

    public static <E extends Comparable<? super E>> boolean isBST(BiTreeNode<E> root) {
        return isBSTInner(root).isBST;
    }


    private static <E extends Comparable<? super E>> Result<E> isBSTInner(BiTreeNode<E> node) {
        if (null == node) {
            return new Result<>(true, null, null);
        }

        Result<E> l = isBSTInner(node.left);
        if (!l.isBST ||
                (null != l.maxElement && l.maxElement.compareTo(node.element) > 0)) {
            return new Result<>(false, null, null);
        }
        Result<E> r = isBSTInner(node.right);
        if (!r.isBST ||
                (null != r.minElement && r.maxElement.compareTo(node.element) <= 0)) {
            return new Result<>(false, null, null);
        }

        return new Result<>(true,
                l.minElement == null ? node.element : l.minElement,
                r.maxElement == null ? node.element : r.maxElement);
    }
}
