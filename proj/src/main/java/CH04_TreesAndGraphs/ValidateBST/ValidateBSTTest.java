package CH04_TreesAndGraphs.ValidateBST;

// Implement a function to check if a binary tree is a binary search tree.
// Hints: #35, #57, #86, #113, #128

import CH04_TreesAndGraphs.ListOfDepths.ListOfDepths_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

// You should ask the interviewer that how to deal with duplicate values.
// Here we assume, we only allow the duplicate values on the left side.
public class ValidateBSTTest {
    public static void main(String[] args) {
        // Integer[] arrExex = {8};
        // BiTreeNode<Integer> treeEx = BiTreeNode.createBSTFromSortedArray(arrExex);
        // int m = ThreadLocalRandom.current().nextInt(5, 25);
        // for (int i = 0; i < m; i++) {
        //     BiTreeNode.insert(treeEx, ThreadLocalRandom.current().nextInt(5, 99));
        // }
        // ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1ex = ListOfDepths_v1.createListOfDepth(treeEx);
        // for (int i = 0; i < arrayList1ex.size(); i++) {
        //     System.out.println(arrayList1ex.get(i));
        // }
        // System.out.println(ValidateBST_v1.isBST(treeEx));
        // System.out.println();
        // System.out.println(ValidateBST_v2.isBST(treeEx));
        // System.out.println();
        // System.out.println(ValidateBST_v3.isBST(treeEx));
        // System.out.println();
        // System.out.println(ValidateBST_v4.isBST(treeEx));
        // System.out.println();
        //
        // System.out.println("////////////////////");

        int n = 1;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BiTreeNode<Integer> tree = BiTreeNode.createBSTFromSortedArray(arr);
        BiTreeNode.insert(tree, 1);
        //BiTreeNode.insert(tree, 7);
        BiTreeNode.insert(tree, 2);
        BiTreeNode.insert(tree, 3);
        //BiTreeNode.insert(tree, -1);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1 = ListOfDepths_v1.createListOfDepth(tree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
        System.out.println(ValidateBST_v1.isBST(tree));
        System.out.println();
        System.out.println(ValidateBST_v2.isBST(tree));
        System.out.println();
        System.out.println(ValidateBST_v3.isBST(tree));
        System.out.println();
        System.out.println(ValidateBST_v4.isBST(tree));
        System.out.println();

        System.out.println();
        Integer[] arrEx = {7, 4, 6, 7, 12, 56, 8, 12, 9};
        BiTreeNode<Integer> tree2 = BiTreeNode.createBSTFromSortedArray(arrEx);
        System.out.println(ValidateBST_v1.isBST(tree2));
        System.out.println();
        System.out.println(ValidateBST_v2.isBST(tree2));
        System.out.println();
        System.out.println(ValidateBST_v3.isBST(tree2));
        System.out.println();
        System.out.println(ValidateBST_v4.isBST(tree2));
        System.out.println();
        //
        System.out.println();
        Integer[] arr3 = {1, 2, 3, 4, 4, 5, 6};
        BiTreeNode<Integer> tree3 = BiTreeNode.createBSTFromSortedArray(arr3);
        System.out.println(ValidateBST_v1.isBST(tree3));
        System.out.println();
        System.out.println(ValidateBST_v2.isBST(tree3));
        System.out.println();
        System.out.println(ValidateBST_v3.isBST(tree3));
        System.out.println();
        System.out.println(ValidateBST_v4.isBST(tree3));
        System.out.println();

        //int n = ThreadLocalRandom.current().nextInt(5, 15);
    }
}
