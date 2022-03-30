package CH10_SortingAndSearching.SortedMerge;

public class SortedMerge_v1 {
    public static void merge(int[] a, int[] b, int countA, int countB) {
        int l = countA+countB - 1;
        countA--;
        countB--;
        while (countA >= 0 && countB >= 0) {
            if (a[countA] >= b[countB]) {
                a[l--] = a[countA--];
            } else {
                a[l--] = b[countB--];
            }
        }

        while (countA >=0) {
            a[l--] = a[countA--];
        }

        while (countB >= 0) {
            a[l--] = b[countB--];
        }
    }
}
