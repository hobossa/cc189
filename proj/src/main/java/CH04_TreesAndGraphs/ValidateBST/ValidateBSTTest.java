package CH04_TreesAndGraphs.ValidateBST;

// Implement a function to check if a binary tree is a binary search tree.
// Hints: #35, #57, #86, #113, #128

import CH04_TreesAndGraphs.CheckBalanced.CheckBalanced_v1;
import CH04_TreesAndGraphs.CheckBalanced.CheckBalanced_v2;
import Common.BiTreeNode;

import java.util.concurrent.ThreadLocalRandom;

// You should ask the interviewer that how to deal with duplicate values.
// Here we assume, we only allow the duplicate values on the left side.
public class ValidateBSTTest {
    public static void main(String[] args) {
        //int n = ThreadLocalRandom.current().nextInt(5, 15);
        int n = 6;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BiTreeNode<Integer> tree = BiTreeNode.createBSTFromSortedArray(arr);
        System.out.println(ValidateBST_v1.isBST(tree));
        System.out.println();
        System.out.println(ValidateBST_v2.isBST(tree));
        System.out.println();
        System.out.println(ValidateBST_v3.isBST(tree));
        System.out.println();

        System.out.println();
        Integer[] arrEx = {7,4,6,7,12,56,8,12,9};
        BiTreeNode<Integer> tree2 = BiTreeNode.createBSTFromSortedArray(arrEx);
        System.out.println(ValidateBST_v1.isBST(tree2));
        System.out.println();
        System.out.println(ValidateBST_v2.isBST(tree2));
        System.out.println();
        System.out.println(ValidateBST_v3.isBST(tree2));
        System.out.println();
    }
}