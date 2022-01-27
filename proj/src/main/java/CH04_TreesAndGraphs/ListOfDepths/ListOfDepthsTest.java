package CH04_TreesAndGraphs.ListOfDepths;

// Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth
// (e.g., if you have a tree with depth D, you'll have D linked lists).
// Hints: #107, #123, #135

import CH04_TreesAndGraphs.MinimalTree.MinimalTree_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class ListOfDepthsTest {

    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(5, 15);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BiTreeNode<Integer> minimalTree = MinimalTree_v1.generateTreeFromSortedArray(arr);
        ArrayList<LinkedList<BiTreeNode<Integer>>>  arrayList1 = ListOfDepths_v1.createListOfDepth(minimalTree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }

        System.out.println();
        ArrayList<LinkedList<BiTreeNode<Integer>>>  arrayList2 = ListOfDepths_v2.createListOfDepth(minimalTree);
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }

        System.out.println();
        ArrayList<LinkedList<BiTreeNode<Integer>>>  arrayList3 = ListOfDepths_v3.createListOfDepth(minimalTree);
        for (int i = 0; i < arrayList3.size(); i++) {
            System.out.println(arrayList3.get(i));
        }
    }
}
