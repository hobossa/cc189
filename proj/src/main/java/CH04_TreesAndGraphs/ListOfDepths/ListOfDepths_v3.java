package CH04_TreesAndGraphs.ListOfDepths;

import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths_v3 {

    // return an ArrayList
    // ArrayList[n] contains all nodes on the depth n.
    // BFS approach, time O(n), space O(n)
    public static <E> ArrayList<LinkedList<BiTreeNode<E>>> createListOfDepth(BiTreeNode<E> root) {
        ArrayList<LinkedList<BiTreeNode<E>>> arrayList = new ArrayList<>();
        int depth = 0;
        LinkedList<BiTreeNode<E>> curList = new LinkedList<>();
        curList.add(root);
        while (curList.size() > 0) {
            arrayList.add(curList);
            LinkedList<BiTreeNode<E>> nextList = new LinkedList<>();
            curList.forEach((node) -> {
                if (null != node.left) {
                    nextList.add(node.left);
                }
                if (null != node.right) {
                    nextList.add(node.right);
                }
            });
            curList = nextList;
        }
        return arrayList;
    }
}
