package CH10_SortingAndSearching.SortedSearchNoSize;

public class SortedSearchNoSize_v1 {
    public static int search(Listy list, int x) {
        if (x < list.elementAt(0)) {
            return -1;
        }
        // int s = 0;
        // int e = x;
        // while (list.elementAt(e) != -1 && list.elementAt(e) < x) {
        //     s = e;
        //     e = 2 * e;
        // }
        // return searchHelper(list, x, s, e);
        int e = 1;
        while (list.elementAt(e) != -1 && list.elementAt(e) < x) {
            e *= 2;
        }
        return searchHelper(list, x, e/2, e);
    }

    private static int searchHelper(Listy list, int x, int s, int e) {
        int n = (s + e) / 2;
        if (list.elementAt(n) == x) {
            return n;
        }

        if (s > e) {
            return -1;
        }

        if (list.elementAt(n) == -1 || list.elementAt(n) > x) {
            return searchHelper(list, x, s, n - 1);
        } else {
            return searchHelper(list, x, n+1, e);
        }
    }
}
