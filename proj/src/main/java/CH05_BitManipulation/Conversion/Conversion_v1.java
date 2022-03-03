package CH05_BitManipulation.Conversion;

public class Conversion_v1 {
    public static final int SEQUENCE_LENGTH = 32;

    public static int bitFlipRequired(int m, int n) {
        int c = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if ((m & 1) != (n & 1)) {
                c++;
            }
            m = m >>> 1;
            n = n >>> 1;
        }
        return c;
    }
}
