package CH04_TreesAndGraphs.BST_Sequences;

// A binary search tree was created by traversing through an array from left to right and inserting each element.
// Given a binary search tree with distinct elements, print all possible arrays that could have led to this tree.
// EXAMPLE
// Input:
//      2
//    /   \
//   1     3
// Output: {2, 1, 3}, {2, 3, 1}
// Hints: #39, #48, #66, #82

import CH04_TreesAndGraphs.ListOfDepths.ListOfDepths_v1;
import Common.BiTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class BST_SequencesTest {
    public static void main(String[] args) {
        // testLinkedListClone();
        int n = 7;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        BiTreeNode<Integer> tree = BiTreeNode.createBSTFromSortedArray(arr);
        ArrayList<LinkedList<BiTreeNode<Integer>>> arrayList1 = ListOfDepths_v1.createListOfDepth(tree);
        for (int i = 0; i < arrayList1.size(); i++) {
            System.out.println(arrayList1.get(i));
        }

        System.out.println();
        System.out.println();
        LinkedList<LinkedList<BiTreeNode<Integer>>> sequences = BST_Sequences_v1.getSequences(tree);
        for( LinkedList<BiTreeNode<Integer>> seq: sequences) {
            for (BiTreeNode<Integer> e : seq) {
                System.out.print(" " + e.element);
            }
            System.out.println();
        }

        System.out.println();
        System.out.println();
        ArrayList<LinkedList<Integer>> sequences2 = BST_Sequences_v2.getSequences(tree);
        for (LinkedList<Integer> seq : sequences2) {
            for (Integer i : seq) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }


    public static void testLinkedListClone() {
        // Creating an empty LinkedList
        LinkedList<String> list = new LinkedList<String>();

        // Use add() method to add elements in the list
        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");

        // Displaying the list
        System.out.println("First LinkedList:" + list);

        // Creating another linked list and copying
        LinkedList sec_list = new LinkedList();
        sec_list = (LinkedList) list.clone();
        sec_list.add("30");

        // Displaying the other linked list
        System.out.println("Second LinkedList is:" + sec_list);
    }
}
