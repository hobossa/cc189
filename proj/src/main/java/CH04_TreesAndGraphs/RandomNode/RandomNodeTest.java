package CH04_TreesAndGraphs.RandomNode;

// You are implementing a binary tree class from scratch which, in addition to insert, find, and delete,
// has a method getRandomNode() which returns a random node from the tree. All nodes should be equally
// likely to be chosen. Design and implement an algorithm for getRandomNode, and explain how you would
// implement the rest of the methods.

// Hints: #42, $54, #62, #75, #89, #99, #112, #119.

import CH04_TreesAndGraphs.ListOfDepths.ListOfDepths_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class RandomNodeTest {
    public static void main(String[] args) {
        int n = 15;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        BiTreeNode<Integer> tree = BiTreeNode.createBSTFromSortedArray(arr);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1 = ListOfDepths_v1.createListOfDepth(tree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
        System.out.println("/////////////");

        for (int i = 0; i < 15; i++) {
            System.out.println(RandomNodeTest_v1.getAtIndex(tree, i));
        }
        System.out.println("/////////////");

        for (int i = 0; i < 20; i++) {
            System.out.println(RandomNodeTest_v1.getRandomNode(tree));
        }

    }
}
