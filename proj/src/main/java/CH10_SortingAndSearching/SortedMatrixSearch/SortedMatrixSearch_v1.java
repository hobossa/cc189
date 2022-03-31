package CH10_SortingAndSearching.SortedMatrixSearch;

public class SortedMatrixSearch_v1 {
    public static Coordinate search(int[][] matrix, int v) {
        if (matrix.length < 1 || matrix[0].length < 1) return new Coordinate(-1, -1);

        Coordinate topLeft = new Coordinate(0, 0);
        Coordinate bottomRight = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        return searchHelper(matrix, v, topLeft, bottomRight);
    }

    private static Coordinate searchHelper(int[][] matrix, int v, Coordinate topLeft, Coordinate bottomRight) {
        if (topLeft.row > bottomRight.row || topLeft.col > bottomRight.col) return new Coordinate(-1, -1);
        int midRow = (topLeft.row + bottomRight.row) / 2;
        int midCol = (topLeft.col + bottomRight.col) / 2;
        //Coordinate mid = new Coordinate(midRow, midCol);
        if (v == matrix[midRow][midCol]) {
            return new Coordinate(midRow, midCol);
        } else if (v < matrix[midRow][midCol]) {
            // search other 3 regions: topLeft topRight, bottomLeft.
            Coordinate temp = searchHelper(matrix, v, topLeft, new Coordinate(midRow-1, midCol-1));
            if (isValid(temp)) {
                return temp;
            }
            temp = searchHelper(matrix, v, new Coordinate(topLeft.row, midCol), new Coordinate(midRow-1, bottomRight.col));
            if (isValid(temp)) {
                return temp;
            }
            temp = searchHelper(matrix, v, new Coordinate(midRow, topLeft.col), new Coordinate(bottomRight.row, midCol-1));
            return temp;
        } else { // (v > matrix[mid.row][mid.col])
            // search other 3 regions: topRight, bottomLeft, bottomRight.
            Coordinate temp = searchHelper(matrix, v, new Coordinate(topLeft.row, midCol+1), new Coordinate(midRow, bottomRight.col));
            if (isValid(temp)) {
                return temp;
            }
            temp = searchHelper(matrix, v, new Coordinate(midRow+1, topLeft.col), new Coordinate(bottomRight.row, midCol));
            if (isValid(temp)) {
                return temp;
            }
            temp = searchHelper(matrix, v, new Coordinate(midRow+1, midCol+1), bottomRight);
            return temp;
        }
    }

    private static boolean isValid(Coordinate coord) {
        if (coord.row != -1 && coord.col != -1) {
            return true;
        }
        return false;
    }
}
