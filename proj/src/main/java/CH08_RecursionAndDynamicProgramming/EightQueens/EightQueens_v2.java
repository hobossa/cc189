package CH08_RecursionAndDynamicProgramming.EightQueens;

import java.util.ArrayList;
import java.util.Arrays;

// solutions from book, page 364
public class EightQueens_v2 {
    private static final int GRID_SIZE = 8;

    public static ArrayList<Integer[]> EightQueens() {
        ArrayList<Integer[]> sols = new ArrayList<>();
        Integer[] cols = new Integer[GRID_SIZE];
        placeQueens(0, cols, sols);
        return sols;
    }

    private static void placeQueens(int row, Integer[] columns, ArrayList<Integer[]> results) {
        if (row == GRID_SIZE) {
            // Found valid placement
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (checkValid(columns, row, col)) {
                    columns[row] = col; // Place queen
                    placeQueens(row+1, columns, results);
                }
            }
        }
    }

    // Check if (row1, col1) is a valid spot for a queen by checking if there is a queen in the same
    // column or diagonal. We don't need to check it for queens in the same row because the calling
    // placeQueen only attempts to place one queen at a time. We know this row is empty.
    private static boolean checkValid(Integer[] columns, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];

            if (col1 == col2) {
                return false;
            }

            int colDistance = Math.abs(col1 - col2);
            int rowDistance = row1 - row2;
            if (colDistance == rowDistance) {
                return false;
            }
        }
        return true;
    }
}
