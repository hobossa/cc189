package CH04_TreesAndGraphs.CheckSubtree;

// T1 and T2 are two very large binary trees, with T1 much bigger than T2.
// Create an algorithm to determine if T2 is a subtree of T1.
// A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
// That is , if you cut off the tree at node n, the two trees would be identical.
// Hints : #4, #11, #18, #31, #37

import CH04_TreesAndGraphs.ListOfDepths.ListOfDepths_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class CheckSubTreeTest {
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

        n = 3;
        Integer[] arr2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = i;
        }

        BiTreeNode<Integer> tree2 = BiTreeNode.createBSTFromSortedArray(arr2);
        //BiTreeNode.insert(tree2, 11);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList2 = ListOfDepths_v1.createListOfDepth(tree2);
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }

       System.out.println(CheckSubTree_v1.isSubTree(tree, tree2));

        // Integer[] arr3 = new Integer[]{1,2,3};
        // for (Integer i : arr3) {
        //     System.out.println(i);
        // }
    }
}
