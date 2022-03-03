package CH05_BitManipulation.DrawLine;

public class DrawLine_v2 {

    // Does your code handle the case when x1 and x2 are in the same byte?
    public static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        assert (x2 >= x1);
        int m = (y * width + x1) / 8;
        int n = (y * width + x2) / 8;

        // draw full bytes
        for (int i = m + 1; i < n; i++) {
            screen[i] = (byte) 0xff;
        }

        byte sMask = (byte) (0xFF >> (x1 % 8));
        byte eMask = (byte) (0xff << ( 7 - (x2 % 8)));
        if (m == n) {
            screen[m] = (byte) (sMask & eMask);
        } else {
            screen[m] = sMask;
            screen[n] = eMask;

        }
    }
}
