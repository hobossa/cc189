package CH10_SortingAndSearching.PeaksAndValleys;

import java.util.Arrays;

public class PeaksAndValleys_v1 {
    public static int[] sort(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] ret = new int[len];
        int start = 0;
        int end = len -1;
        int i = 0;
        while (true) {
            if (i >= len) return ret;
            ret[i++] = arr[end--];
            if (i >= len) return ret;
            ret[i++] = arr[start++];
        }
    }
}
