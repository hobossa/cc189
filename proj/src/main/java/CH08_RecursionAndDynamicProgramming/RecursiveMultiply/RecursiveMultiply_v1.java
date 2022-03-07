package CH08_RecursionAndDynamicProgramming.RecursiveMultiply;

public class RecursiveMultiply_v1 {
    // version 1, brute force, only use bit shifting and addition.
    public static int multiply(int x, int y) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (((y >> i) & 1) == 1) {
                result += (x << i);
            }
        }
        return result;
    }
}
