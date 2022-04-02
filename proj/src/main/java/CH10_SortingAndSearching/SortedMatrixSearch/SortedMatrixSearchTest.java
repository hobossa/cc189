package CH10_SortingAndSearching.SortedMatrixSearch;

// Sorted Matrix Search: Given an M x N matrix in which each row and each column is sorted in
// ascending order, write a method to find an element.
// Hints:#193, #211, #229, #251, #266, #279, #288, #297, #303, #317, #330

public class SortedMatrixSearchTest {
    public static void main(String[] args) {
        int[][] matrix = {
                {15, 30, 50, 70, 73},
                {35, 40, 100, 102, 120},
                {36, 42, 105, 110, 125},
                {46, 51, 106, 111, 130},
                {48, 55, 109, 140, 150}};

        int count = 0;
        for (int i = 0; i < 160; i++) {
            // System.out.println("--- " + i);
            // Coordinate c = SortedMatrixSearch_v1.search(matrix, i);
            Coordinate c = SortedMatrixSearch_v3.search(matrix, i);
            if (c.col != -1 && c.row != -1) {
                System.out.println(i + ": (" + c.row + ", " + c.col + ")");
                count++;
            }
        }
        System.out.println("Found " + count + " unique elements.");
    }
}
