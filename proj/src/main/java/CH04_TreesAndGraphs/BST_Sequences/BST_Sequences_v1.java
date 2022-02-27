package CH04_TreesAndGraphs.BST_Sequences;

import Common.BiTreeNode;

import java.util.LinkedList;

public class BST_Sequences_v1 {

    public static <E> LinkedList<LinkedList<BiTreeNode<E>>>  getSequences(BiTreeNode<E> node) {
        LinkedList<LinkedList<BiTreeNode<E>>> result = new LinkedList<>();
        if (null != node) {
            LinkedList<BiTreeNode<E>> cur = new LinkedList<>();
            cur.add(node);
            result.add(cur);
            getSequences(node, result);
        }
        return result;
    }

    private static <E> void getSequences(BiTreeNode<E> node,
                                         LinkedList<LinkedList<BiTreeNode<E>>> seqLists){
        assert (node != null);
        // if (node == null) {
        //     return;
        // }
        if (node.left != null && node.right != null) {
            // left != null && right != null
            LinkedList<LinkedList<BiTreeNode<E>>> temp1 = new LinkedList<>();
            // LinkedList<LinkedList<BiTreeNode<E>>> temp2 = new LinkedList<>();

            for (LinkedList<BiTreeNode<E>> seq : seqLists) {
                temp1.add((LinkedList<BiTreeNode<E>>) seq.clone());
                // temp2.add((LinkedList<BiTreeNode<E>>) seq.clone());
            }

            // go left first then right
            for (LinkedList<BiTreeNode<E>> seq : temp1) {
                seq.add(node.left);
            }
            getSequences(node.left, temp1);
            for (LinkedList<BiTreeNode<E>> seq : temp1) {
                seq.add(node.right);
            }
            getSequences(node.right, temp1);

            // go right first then left
            for (LinkedList<BiTreeNode<E>> seq : seqLists) {
                seq.add(node.right);
            }
            getSequences(node.right, seqLists);
            for (LinkedList<BiTreeNode<E>> seq : seqLists) {
                seq.add(node.left);
            }
            getSequences(node.left, seqLists);
            // merge
            seqLists.addAll(temp1);
        } else if (node.left != null || node.right != null) {
            // only one child is not null
            // left != null && right == null or
            // left == null && right != null
            BiTreeNode<E> child = node.left != null ? node.left : node.right;
            for (LinkedList<BiTreeNode<E>> seq : seqLists) {
                seq.add(child);
            }
            getSequences(child, seqLists);
        } else {
            // both children are null
            // left == null && right == null
            ;
        }
    }
}
