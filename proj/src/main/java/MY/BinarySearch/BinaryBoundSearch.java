package MY.BinarySearch;

import java.util.Hashtable;
import java.util.List;

public class BinaryBoundSearch {

    // return the first element that greater or equal to k.
    // return -1 if not such an element exists.
    // arr should be in ascending order.
    public static int lowerBound(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (arr[mid] < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
            // if (arr[mid] >= k) {
            //     end = mid;
            // } else {
            //     start = mid + 1;
            // }
        }
        return (start < arr.length && arr[start] >= k) ? start : -1;
    }

    public static int lowerBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) < target)
                l = mid + 1;
            else
                r = mid;
        }

        return list.get(l) >= target ? l : -1;
    }

    // return the last element that smaller or equal to k
    public static int upperBound(int[] arr, int k) {
        int start = 0;
        int end = arr.length;
        int mid;
        while (start < end - 1) {
            mid = (start + end) / 2;
            if (arr[mid] > k) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return (start < arr.length && arr[start] <= k) ? start : -1;
    }

    // returns index of the smallest element in the list bigger than target,
    // or -1 if there is no such element.
    public static int upperBound(List<Integer> list, int target) {
        if (list == null || list.size() == 0)
            return -1;

        int l = 0, r = list.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (list.get(mid) <= target)
                l = mid + 1;
            else
                r = mid;
        }

        return list.get(l) > target ? l : -1;
    }


    public static void main(String[] args) {
        int len = 19;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = i * 10;
            System.out.print(" " + i + "-" + arr[i]);
        }
        System.out.println();

        for (int i = 0; i < len + 2; i++) {
            int t = i * 10 - 5;
            System.out.print(" " + t + ":" + lowerBound(arr, t));
        }
        System.out.println();

        for (int i = 0; i < len + 2; i++) {
            int t = i * 10 - 5;
            System.out.print(" " + t + ":" + upperBound(arr, t));
        }
        System.out.println();
    }
}
