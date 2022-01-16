package ArraysAndStrings;

// Write an algorithm such that if an element in an M x N matrix is 0, its entire row and column are set to 0.
// Hints: #17, #74, #102

import java.util.HashSet;

public class ZeroMatrix {
    public static void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    public static void nullifyColumn(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    // time O(m x n), space O(m + n)
    public static boolean zeroMatrix_v1(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // m rows n cols matrix
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] rowMark = new boolean[m];
        boolean[] colMark = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == matrix[i][j]) {
                    rowMark[i] = true;
                    colMark[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (rowMark[i]) {
                nullifyRow(matrix, i);
            }
        }
        for (int j = 0; j < n; j++) {
            if (colMark[j]) {
                nullifyColumn(matrix, j);
            }
        }
        return true;
    }

    // time O(m x n), space O(1)
    public static boolean zeroMatrix_v2(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // m rows n cols matrix
        // save the number of rows needed to be zeroed at the first col of the matrix
        // save the number of cols needed to be zeroed at the first row of the matrix
        // in this way we don't need extra space of O(M+N),
        // but we cannot mark the first col and the first row in the matrix[0][0] at the same time.
        // we use two extra boolean variables to solve this problem.
        // Although we can use matrix[0][0] to save one of these boolean variables,
        // I prefer to use two variables to make code more clear.
        boolean zeroFirstRow = false;
        boolean zeroFirstCol = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (0 == matrix[i][j]) {
                    // mark rows
                    if (0 == i) {
                        zeroFirstRow = true;
                    } else {
                        matrix[i][0] = 0;
                    }
                    // mark cols
                    if (0 == j) {
                        zeroFirstCol = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (0 == matrix[i][0]) {
                nullifyRow(matrix, i);
            }
        }
        for (int j = 1; j < n; j++) {
            if (0 == matrix[0][j]) {
                nullifyColumn(matrix, j);
            }
        }
        if (zeroFirstRow) {
            nullifyRow(matrix, 0);
        }
        if (zeroFirstCol) {
            nullifyColumn(matrix, 0);
        }
        return true;
    }

    // test
    public static int[][] cloneMatrix(int[][] matrix) {
        int[][] c = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                c[i][j] = matrix[i][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 0, 3, 0, 5},
                {6, 7, 8, 9, 10},
                {11, 0, 13, 14, 15},
                {16, 17, 18, 19, 20},

        };
        printMatrix(matrix);

        System.out.println("\ndo zero matrix_v1:");
        int[][] matrix_v1 = cloneMatrix(matrix);
        zeroMatrix_v1(matrix_v1);
        printMatrix(matrix_v1);

        System.out.println("\ndo zero matrix_v2:");
        int[][] matrix_v2 = cloneMatrix(matrix);
        zeroMatrix_v2(matrix_v2);
        printMatrix(matrix_v2);

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //System.out.print(matrix[i][j] + " ");
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println("");
        }
    }
}
