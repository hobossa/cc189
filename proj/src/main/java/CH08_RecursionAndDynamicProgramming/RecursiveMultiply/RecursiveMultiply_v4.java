package CH08_RecursionAndDynamicProgramming.RecursiveMultiply;

public class RecursiveMultiply_v4 {
    // solution from book
    public static int multiply(int x, int y) {
        int smaller = x > y ? y : x;
        int bigger = x > y ? x : y;
        return multiplyHelper(smaller, bigger);
    }

    private static int multiplyHelper(int s, int b) {
        if (s == 0) {
            return 0;
        } else if (s == 1) {
            return b;
        }
        // try to do half first
        int temp = multiply(s >> 1, b);
        if (s % 2 == 0) {
            return temp + temp;
        } else {
            return temp + temp + b;
        }
    }
}
