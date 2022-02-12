package CH04_TreesAndGraphs.FirstCommonAncestor;

// a similar solution to book
// https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_08_First_Common_Ancestor/QuestionD.java

import Common.BiTreeNode;

public class FirstCommonAncestor_v4 {

    public static <E> BiTreeNode<E> firstCommonAncestor(BiTreeNode<E> root, BiTreeNode<E> nodeA, BiTreeNode<E> nodeB) {
        assert (nodeA != nodeB);
        if (!(coverNode(root, nodeA) && coverNode(root, nodeB))) {
            return null;
        }

        if (coverNode(root.left, nodeA) && coverNode(root.left, nodeB)) {
            return firstCommonAncestor(root.left, nodeA, nodeB);
        }
        if (coverNode(root.right, nodeA) && coverNode(root.right, nodeB)) {
            return firstCommonAncestor(root.right, nodeA, nodeB);
        }

        return root;
    }

    // Checks how many 'special' nodes are located under this node
    public static <E> boolean coverNode(BiTreeNode<E> root, BiTreeNode<E> node) {
        if (root == null) return false;
        if (root == node) {
            return true;
        }
        return coverNode(root.left, node) || coverNode(root.right, node);
    }
}
