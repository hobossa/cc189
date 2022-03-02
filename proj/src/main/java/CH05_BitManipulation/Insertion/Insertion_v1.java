package CH05_BitManipulation.Insertion;

public class Insertion_v1 {
    // time O(j-i)
    // In fact, we don't need to do it with a loop.
    public static int insertion(int n, int m, int i, int j) {
        // Validation
        if (i > j || i < 0 || j >= 32) {
            return 0;
        }

        int t = 0;
        while (i <= j) {
            boolean b = getBit(m, t);
            n = b ? setBit(n, i) : clearBit(n, i);
            t++;
            i++;
        }
        return n;
    }

    private static boolean getBit(int num, int i) {
        int mask = 1 << i;
        return (num & mask) != 0;
    }

    private static int setBit(int num, int i) {
        int mask = 1 << i;
        return num | mask;
    }

    private static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }
}
