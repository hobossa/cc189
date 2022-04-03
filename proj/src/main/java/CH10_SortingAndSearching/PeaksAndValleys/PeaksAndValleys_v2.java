package CH10_SortingAndSearching.PeaksAndValleys;

import java.util.Arrays;

// similar to v1 but space O(1)
// IMO, I don't think modify arguments is a good practice.
public class PeaksAndValleys_v2 {
    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i+=2) {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
    }
}
