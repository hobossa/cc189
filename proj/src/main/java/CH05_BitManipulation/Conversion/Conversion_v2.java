package CH05_BitManipulation.Conversion;

public class Conversion_v2 {
    public static final int SEQUENCE_LENGTH = 32;

    public static int bitFlipRequired(int m, int n) {
        int c = 0;
        int t = m ^ n;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            if ((t & 1) != 0) {
                c++;
            }
            t = t >>> 1;
        }
        return c;
    }
}
