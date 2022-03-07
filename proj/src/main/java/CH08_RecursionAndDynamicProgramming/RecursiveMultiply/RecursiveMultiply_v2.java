package CH08_RecursionAndDynamicProgramming.RecursiveMultiply;

public class RecursiveMultiply_v2 {
    // version 2, similar to version 1, but it may reduce the possible loop times.
    public static int multiply(int x, int y) {
        int smaller = x > y ? y : x;
        int bigger = x > y ? x : y;

        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = smaller >> i;
            if (temp == 0) {
                break;
            }
            if ((temp & 1) == 1) {
                result += (bigger << i);
            }
        }
        return result;
    }
}
