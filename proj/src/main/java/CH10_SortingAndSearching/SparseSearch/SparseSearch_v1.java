package CH10_SortingAndSearching.SparseSearch;

public class SparseSearch_v1 {
    public static int search(String[] array, String str) {
        if (str.compareTo("") == 0) {
            return -1;
        }
        return searchHelper(array, str, 0, array.length - 1);
    }

    private static int searchHelper(String[] array, String str, int s, int e) {
        if (s > e) {
            return -1;
        }

        int n = (s + e) / 2;
        if (array[n].compareTo("") != 0) {
            if (array[n].compareTo(str) == 0) {
                return n;
            }
            if (array[n].compareTo(str) > 0) {
                return searchHelper(array, str, s, n - 1);
            }
            return searchHelper(array, str, n + 1, e);
        }

        int i = searchHelper(array, str, s, n - 1);
        if (-1 == i) {
            i = searchHelper(array, str, n + 1, e);
        }
        return i;
    }
}
