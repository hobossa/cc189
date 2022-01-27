package CH04_TreesAndGraphs.CheckBalanced;

// Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree
// is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
// Hints: #21, #33, #49, #105, #124

import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class CheckBalancedTest {

    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(5, 15);
        // int n = 7;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BiTreeNode<Integer> tree = BiTreeNode.createBSTFromSortedArray(arr);
        System.out.println(CheckBalanced_v1.isBalanced(tree));
        System.out.println();
        System.out.println(CheckBalanced_v2.isBalanced(tree));
        System.out.println();

        BiTreeNode.insert(tree, 20);
        BiTreeNode.insert(tree, 21);
        BiTreeNode.insert(tree, 22);
        System.out.println(CheckBalanced_v1.isBalanced(tree));
        System.out.println();
        System.out.println(CheckBalanced_v2.isBalanced(tree));
        System.out.println();
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1 = BiTreeNode.toListOfDepth(tree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }
    }
}
