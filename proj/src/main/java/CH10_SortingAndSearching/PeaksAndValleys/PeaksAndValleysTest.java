package CH10_SortingAndSearching.PeaksAndValleys;


// Peaks and Valleys: In an array of integers, a "peak" is an element which is greater than or equal to
// the adjacent integers and a "valley" is an element which is less than or equal to the adjacent integers.
// For example, in the array {5, 8, 6, 2, 3, 4, 6}, {8, 6} are peaks and {5, 2} are valleys. Given an array
// of integers, sort the array into an alternating sequence of peaks and valleys.
// EXAMPLE
// Input: {5, 3, 1, 2, 3}
// Output: {5, 1, 3, 2, 3}
// Hints: #196, #219, #231, #253, #277, #292, #316

import java.util.concurrent.ThreadLocalRandom;

public class PeaksAndValleysTest {
    public static void main(String[] args) {
        // int[] arr = {5,3,1,2,3};
        int len = 10;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            int n = ThreadLocalRandom.current().nextInt(10,99);
            arr[i] = n;
            System.out.print(" " + n);
        }
        System.out.println("");
        System.out.println("//////////////");

        // int[] arr = {73, 94, 54, 85, 40, 50, 84};

        PeaksAndValleys_v3.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();

        int[] r = PeaksAndValleys_v1.sort(arr);
        for (int i = 0; i < r.length; i++) {
            System.out.print(" " + r[i]);
        }
        System.out.println();

        PeaksAndValleys_v2.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
        System.out.println();
    }
}
