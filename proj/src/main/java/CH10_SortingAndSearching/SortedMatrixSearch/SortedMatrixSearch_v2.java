package CH10_SortingAndSearching.SortedMatrixSearch;

public class SortedMatrixSearch_v2 {

    public static Coordinate search(int[][] matrix, int v) {
        if (matrix.length < 1 || matrix[0].length < 1) return new Coordinate(-1, -1);

        int col = 0;
        int row = matrix.length - 1;
        while (row >= 0 && col < matrix[0].length) {
            if (v == matrix[row][col]) {
                return new Coordinate(row, col);
            } else if (v > matrix[row][col]) {
                col++;
            } else {    // v < matrix[row][col]
                row--;
            }
        }
        return new Coordinate(-1, -1);
    }
}
