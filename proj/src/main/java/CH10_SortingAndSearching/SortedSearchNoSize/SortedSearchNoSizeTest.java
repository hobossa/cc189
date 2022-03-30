package CH10_SortingAndSearching.SortedSearchNoSize;

// Sorted Search, No Size: You are given an array like data structure Listy which lacks a size
// method. It does, however, have an elementAt(i) method that returns the element at index i in
// 0(1) time. If i is beyond the bounds of the data structure, it returns -1. (For this reason, the data
// structure only supports positive integers.) Given a Li sty which contains sorted, positive integers,
// find the index at which an element x occurs. If x occurs multiple times, you may return any index.
// Hints: #320, #337, #348

public class SortedSearchNoSizeTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 4, 5, 6, 7, 9, 10, 11, 12, 13, 14, 16, 18};
        Listy list = new Listy(array);
        for (int a : array) {
            System.out.println(SortedSearchNoSize_v1.search(list, a));
        }
        System.out.println(SortedSearchNoSize_v1.search(list, 15));
    }
}
