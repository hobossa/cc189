package CH05_BitManipulation.DrawLine;

// A monochrome screen is stored as a single array of bytes, allowing eight consecutive pixels to be stored
// in one byte. The screen has width w, where w is divisible by 8 (that is, no byte will be split across rows).
// The height of the screen, of course, can be derived from the length of the array and the width.
// Implement a function that draws a horizontal line from (x1, y) to (x2, y).
// The method signature should look something like:
// drawLine(byte[] screen, int width, int x1, int x2, int y)
// Hints: #366, #381, #384, #391


// #391. Does your code handle the case when x1 and x2 are in the same byte?
public class DrawLineTest {

    public static int computeByteNum(int width, int x, int y) {
        return (width * y + x) / 8;
    }

    public static void printByte(byte b) {
        for (int i = 7; i >= 0; i--) {
            char c = ((b >> i) & 1) == 1 ? '1' : '_';
            System.out.print(c);
        }
    }

    public static void printScreen(byte[] screen, int width) {
        int height = screen.length * 8 / width;
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c+=8) {
                byte b = screen[computeByteNum(width, c, r)];
                printByte(b);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int width = 8 * 2;
        int height = 2;
        for (int r = 0; r < height; r++) {
            for (int c1 = 0; c1 < width; c1++) {
                for (int c2 = c1; c2 < width; c2++) {
                    byte[] screen = new byte[width * height / 8];

                    System.out.println("row: " + r + ": " + c1 + " -> " + c2);
                    DrawLine_v1.drawLine(screen, width, c1, c2, r);
                    printScreen(screen, width);
                    System.out.println("\n\n");
                }
            }
        }
    }
}
