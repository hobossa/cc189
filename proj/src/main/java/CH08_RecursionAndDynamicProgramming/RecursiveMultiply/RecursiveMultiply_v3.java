package CH08_RecursionAndDynamicProgramming.RecursiveMultiply;

public class RecursiveMultiply_v3 {
    // Recursion approach.

    public static int multiply(int x, int y) {
        int smaller = x > y ? y : x;
        int bigger = x > y ? x : y;
        return multiplyHelper(smaller, bigger);
    }

    private static int multiplyHelper(int s, int b) {
        if (s == 0) {
            return 0;
        }
        int temp = (s & 1) == 1 ? b : 0;
        return temp + multiply(s>>1, b<<1);
    }
}
