package CH08_RecursionAndDynamicProgramming.MagicIndex;

// A magic index in an array A[0...n-1] is defined to be an index such A[i] = i. Given a sorted array of
// distinct integers, write a method to find a magic index, if one exists, in array A.
// FOLLOW UP
// What if the values are not distinct?
// Hints: #170, #204, #240, #286, #340

import Common.AssortedMethods;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class MagicIndexTest {
    /* Creates an array that is distinct and sorted */
    public static int[] getDistinctSortedArray(int size) {
        int[] array = AssortedMethods.randomArray(size, -1 * size, size);
        Arrays.sort(array);
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i-1]) {
                array[i]++;
            } else if (array[i] < array[i - 1]) {
                array[i] = array[i-1] + 1;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int size = ThreadLocalRandom.current().nextInt(5, 20);
            int[] array = getDistinctSortedArray(size);
            int v1 = MagicIndex_v1.getMagicIndex(array);
            int v2 = MagicIndex_v1.getMagicIndexEx(array);
            if (-1 != v2) {
                for (int j = 0; j < array.length; j++) {
                    System.out.print(" a["+j+"]="+array[j]);
                }
                System.out.println();
                System.out.println(v1);
                System.out.println(v2);
            }
        }
    }
}
