package CH04_TreesAndGraphs.PathsWithSum;

// You are given a binary tree in which each node contains an integer value (which might be positive or negative).
// Design an algorithm to count the number of paths that sum to a given value. The path does not need to start or
// end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

// Hints: #6, #14, #52, #68, #77, #87, #94, #103, #108, #115

import CH04_TreesAndGraphs.ListOfDepths.ListOfDepths_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class PathsWithSumTest {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0, 0, 1, 1, 1, 0, 0};
        BiTreeNode<Integer> tree = BiTreeNode.createBTFromArray(arr);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1 = ListOfDepths_v1.createListOfDepth(tree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
        System.out.println(PathsWithSum_v1.numberOfSumPath(tree, 0));
    }
}
