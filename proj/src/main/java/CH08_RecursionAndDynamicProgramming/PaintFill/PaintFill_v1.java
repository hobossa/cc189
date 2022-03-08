package CH08_RecursionAndDynamicProgramming.PaintFill;

import java.util.HashSet;
import java.util.Set;

public class PaintFill_v1 {

    public static void fill(int x, int y, int newColor, int[][] screen) {
        if (screen.length <= 0 || screen[0].length <= 0) {
            return;
        }
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
            return;
        }
        int color = screen[x][y];
        paint(x, y, color, newColor, screen);
    }

    private static void paint(int x, int y, int oldColor, int newColor, int[][] screen) {
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
            return;
        }
        if (oldColor == screen[x][y]) {
            screen[x][y] = newColor;
            paint(x - 1, y, oldColor, newColor, screen);
            paint(x + 1, y, oldColor, newColor, screen);
            paint(x, y - 1, oldColor, newColor, screen);
            paint(x, y + 1, oldColor, newColor, screen);
        }
    }
}
