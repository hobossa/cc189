package CH05_BitManipulation.Conversion;

public class Conversion_v3 {
    public static int bitFlipRequired(int m, int n) {
        int c = 0;
        int t = m ^ n;
        while (t != 0) {
            c++;
            t = t & (t - 1);    // remove the rightest 1.
        }
        return c;
    }
}
