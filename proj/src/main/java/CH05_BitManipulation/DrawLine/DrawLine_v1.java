package CH05_BitManipulation.DrawLine;

public class DrawLine_v1 {
    // Does your code handle the case when x1 and x2 are in the same byte?
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        assert (x2 >= x1);
        int m = (y * width + x1) / 8;
        int n = (y * width + x2) / 8;

        if (m == n) {
            for (int i = x1 % 8; i <= x2 % 8; i++) {
                screen[m] = (byte) (screen[m] | (1 << (7-i)));
            }
        } else {
            for (int i = x1 % 8; i < 8; i++) {
                screen[m] = (byte) (screen[m] | (1 << (7-i)));
            }

            for (int i = m + 1; i < n; i++) {
                screen[i] = (byte) 0xff;
            }

            for (int i = 0; i <= x2 % 8; i++) {
                screen[n] = (byte) (screen[n] | (1 << (7-i)));
            }
        }
    }
}
