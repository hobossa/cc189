package CH10_SortingAndSearching.SortedMatrixSearch;

import CH01_ArraysAndStrings.StringCompression;

public class SortedMatrixSearch_v3 {
    public static Coordinate search(int[][] matrix, int v) {
        if (matrix.length < 1 || matrix[0].length < 1) return new Coordinate(-1, -1);

        Coordinate topLeft = new Coordinate(0, 0);
        Coordinate bottomRight = new Coordinate(matrix.length - 1, matrix[0].length - 1);
        Coordinate ret = searchHelper(matrix, v, topLeft, bottomRight);
        if (null == ret) {
            ret = new Coordinate(-1, -1);
        }
        return ret;
    }

    private static Coordinate searchHelper(int[][] matrix, int v, Coordinate topLeft, Coordinate bottomRight) {
        if (topLeft.row > bottomRight.row || topLeft.col > bottomRight.col) {
            return null;
        }

        // Do binary search on the diagonal, looking for the last element < x
        int lenDiagonal = Math.min(bottomRight.col - topLeft.col, bottomRight.row - topLeft.row);
        Coordinate start = new Coordinate(topLeft.row, topLeft.col);
        Coordinate end = new Coordinate(topLeft.row + lenDiagonal, topLeft.col + lenDiagonal);
        Coordinate mid = new Coordinate();

        while (start.row <= end.row && start.col <= end.col) {
            mid.row = (start.row + end.row) / 2;
            mid.col = (start.col + end.col) / 2;
            if (matrix[mid.row][mid.col] == v) {
                return mid;
            } else if (matrix[mid.row][mid.col] < v) {
                start.row = mid.row + 1;
                start.col = mid.col + 1;
            } else { // matrix[mid.row][mid.col] < v
                end.row = mid.row - 1;
                end.col = mid.col - 1;
            }
        }

        Coordinate topLeft1 = new Coordinate(end.row + 1, topLeft.col);
        Coordinate bottomRight1 = new Coordinate(bottomRight.row, end.col);
        Coordinate topLeft2 = new Coordinate(topLeft.row, start.col);
        Coordinate bottomRight2 = new Coordinate(start.row - 1, bottomRight.col);
        Coordinate temp = null;
        if (isCoordInRegion(topLeft1, topLeft, bottomRight) && isCoordInRegion(bottomRight1, topLeft, bottomRight)) {
            temp = searchHelper(matrix, v, topLeft1, bottomRight1);
        }
        if (null != temp) return temp;

        if (isCoordInRegion(topLeft2, topLeft, bottomRight) && isCoordInRegion(bottomRight2, topLeft, bottomRight)) {
            temp = searchHelper(matrix, v, topLeft2, bottomRight2);
        }

        return temp;
    }

    private static boolean isCoordInRegion(Coordinate coord, Coordinate topLeft, Coordinate bottomRight) {
        return (coord.row >= topLeft.row && coord.row <= bottomRight.row
                &&
                coord.col >= topLeft.col && coord.col <= bottomRight.col);
    }
}
