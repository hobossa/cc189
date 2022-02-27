package CH04_TreesAndGraphs.BST_Sequences;


import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

// similar to the book's solution
// (https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_09_BST_Sequences/Question.java)
public class BST_Sequences_v2 {

    public static <E> ArrayList<LinkedList<E>> getSequences(BiTreeNode<E> node) {
        ArrayList<LinkedList<E>> result = new ArrayList<>();
        if (node == null) {
            result.add(new LinkedList<E>());
            return result;
        }

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<E>> leftSeq = getSequences(node.left);
        ArrayList<LinkedList<E>> rightSeq = getSequences(node.right);

        for (LinkedList<E> left : leftSeq) {
            for (LinkedList<E> right : rightSeq) {
                if (left.size() > 0 && right.size() > 0) {
                    LinkedList<E> temp1 = new LinkedList<>();
                    temp1.add(node.element);
                    temp1.addAll(left);
                    temp1.addAll(right);
                    result.add(temp1);
                    LinkedList<E> temp2 = new LinkedList<>();
                    temp2.add(node.element);
                    temp2.addAll(right);
                    temp2.addAll(left);
                    result.add(temp2);
                } else if (left.size() > 0 || right.size() > 0) {
                    LinkedList<E> temp1 = new LinkedList<>();
                    temp1.add(node.element);
                    LinkedList<E> noNull = left.size() > 0 ? left : right;
                    temp1.addAll(noNull);
                    result.add(temp1);
                } else {
                    // both children are empty
                    LinkedList<E> temp1 = new LinkedList<>();
                    temp1.add(node.element);
                    result.add(temp1);
                }
            }
        }
        return result;
    }
}
