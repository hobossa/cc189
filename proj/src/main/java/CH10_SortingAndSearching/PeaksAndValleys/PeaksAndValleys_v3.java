package CH10_SortingAndSearching.PeaksAndValleys;


// time O(n), space O(1)

public class PeaksAndValleys_v3 {
    public static void sort(int[] arr) {
        if (arr.length <= 1) return;

        int i = 0;
        while (i + 2 < arr.length) {
            int max = Math.max(arr[i+1], arr[i+2]);
            if (arr[i+2] < arr[i+1]) {
                swap(arr, i+1, i+2);
            }
            if (arr[i] < arr[i+1]) {
                swap(arr, i, i+1);
            }
            i += 2;
        }
        // there is one integer left
        if (i == arr.length -2) {
            if (arr[i] < arr[i+1]) {
                swap(arr, i, i+1);
            }
        }
    }

    private static void swap(int[] arr, int m, int n) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
