package CH04_TreesAndGraphs.Successor;

// Write an algorithm to find the "next" node (i.e., in-order successor) of a given node in a binary search tree.
// You may assume that each node ahs a link to its parent.
// Hints: #79, #91

import Common.BiTreeNode;

public class SuccessorTest {

    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        BiTreeNode<Integer> root = BiTreeNode.createBSTFromSortedArray(array);
        for (int i = 0; i < array.length; i++) {
            BiTreeNode<Integer> node = root.find(root, array[i]);
            BiTreeNode<Integer> next = Successor_v1.getSuccessor(node);
            if (next != null) {
                System.out.println(node.element + "->" + next.element);
            } else {
                System.out.println(node.element + "->" + null);
            }
        }
    }
}
