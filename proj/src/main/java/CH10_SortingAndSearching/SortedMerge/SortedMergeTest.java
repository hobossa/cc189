package CH10_SortingAndSearching.SortedMerge;


// Sorted Merge: You are given two sorted arrays, A and B, where A has a large enough buffer at the
// end to hold B. Write a method to merge B into A in sorted order.
// Hints:#332

import Common.AssortedMethods;

public class SortedMergeTest {

    public static void main(String[] args) {
        int[] a = {2, 3, 4, 5, 6, 8, 10, 100, 0, 0, 0, 0, 0, 0};
        int[] b = {111, 114, 117, 116, 117, 117};
        // SortedMerge_v1.merge(a, b, 8, 6);
        SortedMerge_v2.merge(a, b, 8, 6);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        System.out.println();
    }
}
