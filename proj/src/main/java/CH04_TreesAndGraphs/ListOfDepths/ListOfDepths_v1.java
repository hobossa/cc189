package CH04_TreesAndGraphs.ListOfDepths;

import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths_v1 {
    private static class Pair<E> {
        BiTreeNode<E> node;
        int depth;

        public Pair(BiTreeNode<E> node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    // return an ArrayList
    // ArrayList[n] contains all nodes on the depth n.
    // BFS approach, time O(n), space O(n)
    // This is stupid, we don't need an extra variable to record depth.
    // When we do it in BFS way. Every node in the next List is the child of the current List
    // see ListOfDepths_v3
    public static <E> ArrayList<LinkedList<BiTreeNode<E>>> createListOfDepth(BiTreeNode<E> root) {
        ArrayList<LinkedList<BiTreeNode<E>>> arrayList = new ArrayList<>();

        LinkedList<Pair<E>> queue = new LinkedList<>();
        queue.add(new Pair<E>(root, 0));
        while (!queue.isEmpty()) {
            Pair<E> temp = queue.removeFirst();
            if (arrayList.size() < temp.depth + 1) {
                arrayList.add(new LinkedList<>());
            }
            arrayList.get(temp.depth).add(temp.node);
            if (null != temp.node.left) {
                queue.add(new Pair<>(temp.node.left, temp.depth + 1));
            }
            if (null != temp.node.right) {
                queue.add(new Pair<>(temp.node.right, temp.depth + 1));
            }
        }
        return arrayList;
    }
}
