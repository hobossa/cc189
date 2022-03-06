package CH08_RecursionAndDynamicProgramming.MagicIndex;

public class MagicIndex_v1 {
    public static int getMagicIndex(int[] arr){
        return getMagicIndex(arr, 0, arr.length);
    }

    public static int getMagicIndex(int[] arr, int s, int e) {
        if (s >= e) {
            return -1;
        }
        int n = (s+e)/2;
        if (arr[n] == n) {
            return n;
        } else if (arr[n] > n) {
            return getMagicIndex(arr, s, n);
        } else {
            // arr[n] < n
            return getMagicIndex(arr, n+1, e);
        }
    }


    // *Ex for FOLLOW UP
    public static int getMagicIndexEx(int[] arr){
        return getMagicIndexEx(arr, 0, arr.length -1);
    }
    public static int getMagicIndexEx(int[] arr, int s, int e) {
        if (s > e) {
            return -1;
        }

        int n = (s+e) /2;
        if (arr[n] == n) {
            return n;
        }

        // Search on the left
        int left = getMagicIndexEx(arr, s, Math.min(arr[n], n-1));
        if (left >= 0) {
            return left;
        }

        // search on the right
        int right = getMagicIndexEx(arr, Math.max(arr[n], n+1), e);
        return  right;
    }
}
