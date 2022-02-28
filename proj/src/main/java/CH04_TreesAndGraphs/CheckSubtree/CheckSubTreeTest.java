package CH04_TreesAndGraphs.CheckSubtree;

// T1 and T2 are two very large binary trees, with T1 much bigger than T2.
// Create an algorithm to determine if T2 is a subtree of T1.
// A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical to T2.
// That is , if you cut off the tree at node n, the two trees would be identical.
// Hints : #4, #11, #18, #31, #37

// #4. If T2 is a subtree of T1, how will its in-order traversal compare to T1's? What about its pre-order and
// post-order traversal?

// #11. The in-order traversals won't tell us much. After all, every binary search tree with the same values
// (regardless of structure) will have the same in-order traversal. This is what in-order traversal means: contents
// are in-order. (And if it won't work in the specific case of a binary search tree, then is certainly won't work
// for a general binary tree.) The pre-order traversal, however, is much more indicative.

// #18. You may have concluded that if T2.preorderTraversal() is a substring of T1.preorderTraversal(), then T2
// is a subtree of T1. This is almost true, except that the trees could have duplicate values. Suppose T1 and T2
// have all duplicate values but different structures. The pre-order traversals will look the same even though
// T2 is not a subtree of T1. How can you handle situations like this?

// #31. Although the problem seems like it stems from duplicate values, it's really deeper than that. The issue is
// that the pre-order traversal is the same only because there are null nodes that we skipped over (because they're
// null). Consider inserting a placeholder value into the pre-order traversal string whenever you reach a null node.
// Register the null node as a "real" node so that you can distinguish between the different structures.

// #37. Alternatively, we can handle this problem recursively, Given a specific node with T1, can we check to see if
// its subtree matches T2?

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
        // BiTreeNode.insert(tree2, 11);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList2 = ListOfDepths_v1.createListOfDepth(tree2);
        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.println(arrayList2.get(i));
        }

        System.out.println(CheckSubTree_v1.isSubTree(tree, tree2));
        System.out.println(CheckSubTree_v2.isSubTree(tree, tree2));

        // Integer[] arr3 = new Integer[]{1,2,3};
        // for (Integer i : arr3) {
        //     System.out.println(i);
        // }
    }
}
