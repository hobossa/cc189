package CH10_SortingAndSearching.SearchInRotatedArray;

public class SearchInRotatedArray_v1 {
    public static int search(int[] array, int x) {
        return searchHelper(array, x, 0, array.length - 1);
    }

    private static int searchHelper(int[] array, int x, int s, int e) {
        if (s > e) {
            return -1;
        }
        int n = (s + e) / 2;
        if (x == array[n]) {
            return n;
        }

        if (array[s] < array[e]) {
            // no rotated
            if (x < array[n]) {
                return searchHelper(array, x, s, n - 1);
            } else {
                return searchHelper(array, x, n + 1, e);
            }
        }

        int i = searchHelper(array, x, s, n-1);
        if (-1 != i) {
            return i;
        }

        return searchHelper(array, x, n + 1, e);
    }
}
