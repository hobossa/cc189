package CH04_TreesAndGraphs.MinimalTree;

// Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary
// search tree with minimal height.
// Hints:: #19, #73, #116

import Common.BiTreeNode;

import java.util.concurrent.ThreadLocalRandom;

public class MinimalTreeTest {
    public static void main(String[] args) {
        int n = ThreadLocalRandom.current().nextInt(5, 15);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        BiTreeNode<Integer> minimalTree = MinimalTree_v1.generateTreeFromSortedArray(arr);
        System.out.println("check");
    }
}
