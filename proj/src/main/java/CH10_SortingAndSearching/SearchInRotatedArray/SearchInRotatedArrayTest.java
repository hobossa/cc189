package CH10_SortingAndSearching.SearchInRotatedArray;

// Search in Rotated Array: Given a sorted array of n integers that has been rotated an unknown
// number of times, write code to find an element in the array. You may assume that the array was
// originally sorted in increasing order.
// EXAMPLE
// input:find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
// Output: 8 (the index of 5 in the array)
// Hints:#298, #310

public class SearchInRotatedArrayTest {
    public static void main(String[] args) {
        // int[] a = { 2, 3, 1, 2, 2, 2, 2, 2 , 2 , 2 };
        // SearchInRotatedArray_v1.search(a, 1);
        //
        // System.out.println(SearchInRotatedArray_v1.search(a, 2));
        // System.out.println(SearchInRotatedArray_v1.search(a, 3));
        // System.out.println(SearchInRotatedArray_v1.search(a, 4));
        // System.out.println(SearchInRotatedArray_v1.search(a, 1));
        // System.out.println(SearchInRotatedArray_v1.search(a, 8));

        System.out.println();
        int[] b = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(SearchInRotatedArray_v1.search(b, 7));
        for (int i = 0; i < 26; i++) {
            System.out.print(i);
            System.out.print(" - ");
            System.out.println(SearchInRotatedArray_v1.search(b, i));
        }
    }
}
