package CH04_TreesAndGraphs.ListOfDepths;

import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths_v2 {
    // DFS approach. time O(n), space O(n)
    public static <E> ArrayList<LinkedList<BiTreeNode<E>>> createListOfDepth(BiTreeNode<E> root) {
        ArrayList<LinkedList<BiTreeNode<E>>> arrayList = new ArrayList<>();
        createListOfDepth(arrayList, root, 0);
        return arrayList;
    }

    private static <E> void createListOfDepth(ArrayList<LinkedList<BiTreeNode<E>>> arrayList, BiTreeNode<E> node, int depth) {
        if (arrayList.size() < depth + 1) {
            arrayList.add(new LinkedList<>());
        }
        arrayList.get(depth).add(node);
        if (null != node.left) {
            createListOfDepth(arrayList, node.left, depth + 1);
        }
        if (null != node.right) {
            createListOfDepth(arrayList, node.right, depth + 1);
        }
    }
}
