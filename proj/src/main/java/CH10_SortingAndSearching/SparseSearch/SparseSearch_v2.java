package CH10_SortingAndSearching.SparseSearch;

public class SparseSearch_v2 {
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
        // find the nearest no-empty string.
        // int i = 0;
        // while (true) {
        //     if (n-i >= s && n-i <= e && !array[n-i].isEmpty()) {
        //         n = n-i;
        //         break;
        //     }
        //     if (n+i >=s && n+i <= e && !array[n+i].isEmpty()) {
        //         n = n+i;
        //         break;
        //     }
        //     i++;
        // }
        //
        // if (n < s || n > e) {
        //     return -1;
        // }

        // find the nearest no-empty, the following code is from book which is better
        if (array[n].isEmpty()) {
            int left = n - 1;
            int right = n + 1;
            while (true) {
                if (left < s && right > e) {
                    return -1;
                } else if (left >= s && !array[left].isEmpty()) {
                    n = left;
                    break;
                } else if (right <= e && !array[right].isEmpty()) {
                    n = right;
                    break;
                }
                left--;
                right++;
            }
        }

        if (array[n].compareTo(str) == 0) {
            return n;
        } else if (array[n].compareTo(str) > 0) {
            return searchHelper(array, str, s, n - 1);
        } else {
            return searchHelper(array, str, n + 1, e);
        }
    }
}
