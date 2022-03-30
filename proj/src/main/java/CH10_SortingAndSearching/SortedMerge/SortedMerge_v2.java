package CH10_SortingAndSearching.SortedMerge;

public class SortedMerge_v2 {
    public static void merge(int[] a, int[] b, int countA, int countB) {
        int l = countA+countB - 1;
        countA--;
        countB--;
        while (countB >= 0) {
            if (countA >= 0 && b[countB] < a[countA]) {
                a[l--] = a[countA--];
            } else {
                a[l--] = b[countB--];
            }
        }

        // l = countA in the following codes.
        // so we don't need to move the rest of elements in array A,
        // because they are already in the right positions.
        // while (countA >=0) {
        //     a[l--] = b[countA--];
        // }
    }
}
