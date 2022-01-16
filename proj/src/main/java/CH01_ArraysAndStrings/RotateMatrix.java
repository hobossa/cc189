package CH01_ArraysAndStrings;

// Given an image represented by an N x N Matrix, where each pixel in the mage is 4 bytes, write a method to rotate
// the image by 90 degrees. Can you do this in place?
// Hints: #51, # 100

public class RotateMatrix {

    // int type occupy 4 bits, so we can use int to represent pixels
    public static class Image {
        private int[][] pixels;
        private int n;

        public Image(int[][] pixels, int n) {
            assert (pixels != null && n > 0 && pixels.length == n && pixels[0].length == n);
            this.pixels = pixels;
            this.n = n;
        }

        public void leftRotate() {
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int temp = pixels[i][j];
                    pixels[i][j] = pixels[j][n - 1 - i];
                    pixels[j][n - 1 - i] = pixels[n - 1 - i][n - 1 - j];
                    pixels[n - 1 - i][n - 1 - j] = pixels[n - 1 - j][i];
                    pixels[n - 1 - j][i] = temp;
                    // System.out.println(toString());
                }
            }
        }

        public void rightRotate() {
            for (int i = 0; i < n / 2; i++) {
                for (int j = i; j < n - i - 1; j++) {
                    int temp = pixels[i][j];
                    pixels[i][j] = pixels[n - 1 - j][i];
                    pixels[n - 1 - j][i] = pixels[n - 1 - i][n - 1 - j];
                    pixels[n - 1 - i][n - 1 - j] = pixels[j][n - 1 - i];
                    pixels[j][n - 1 - i] = temp;
                    // System.out.println(toString());
                }
            }
        }

        // solution from book
        public static boolean rotate(int[][] matrix) {
            if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Not a square
            int n = matrix.length;

            for (int layer = 0; layer < n / 2; layer++) {
                int first = layer;
                int last = n - 1 - layer;
                for(int i = first; i < last; i++) {
                    int offset = i - first;
                    int top = matrix[first][i]; // save top

                    // left -> top
                    matrix[first][i] = matrix[last-offset][first];

                    // bottom -> left
                    matrix[last-offset][first] = matrix[last][last - offset];

                    // right -> bottom
                    matrix[last][last - offset] = matrix[i][last];

                    // top -> right
                    matrix[i][last] = top; // right <- saved top
                }
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("Image ");
            strBuilder.append(n);
            strBuilder.append("x");
            strBuilder.append(n);
            strBuilder.append(":\n");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    strBuilder.append(String.format("%3d", pixels[i][j]));
                }
                strBuilder.append('\n');
            }
            return strBuilder.toString();
        }
    }

    // test
    public static void main(String[] args) {
        // int [][] array = {
        //         {1}
        // };
        // int[][] array = {
        //         {1, 2},
        //         {3, 4}
        // };
        // int[][] array = {
        //         {1, 2, 3},
        //         {4, 5, 6},
        //         {7, 8, 9}
        // };
        // int[][] array = {
        //         {1,2,3,4},
        //         {5,6,7,8},
        //         {9,10,11,12},
        //         {13,14,15,16}
        // };
        int[][] array = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        Image image = new Image(array, array.length);
        System.out.println(image.toString());
        image.leftRotate();
        System.out.println("left rotate:");
        System.out.println(image.toString());
        image.rightRotate();
        System.out.println("right rotate:");
        System.out.println(image.toString());

    }
}
