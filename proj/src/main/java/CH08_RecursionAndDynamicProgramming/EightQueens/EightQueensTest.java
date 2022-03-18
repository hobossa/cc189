package CH08_RecursionAndDynamicProgramming.EightQueens;

// Write an algorithm to print all ways of arranging eight queens on an 8x8 chess board
// so that none of them share the same row, column, or diagonal. In this case, "diagonal" means all
// diagonals, not just the two that bisect the board.
// Hints: #308, #350, #371

import java.util.ArrayList;

public class EightQueensTest {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> solutions = EightQueens_v1.EightQueens();
        System.out.println("There are " + solutions.size() + " solutions");
        for (ArrayList<Integer> l : solutions) {
            for (int i = 0; i < l.size(); i++) {
                //System.out.print("(" + i + "," + l.get(i) + ") ");
                for (int j = 0; j < 8; j++) {
                    if (j == l.get(i)) {
                        System.out.print("x ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }

        System.out.println("/////////////////////");
        System.out.println();
        ArrayList<Integer[]> solutions2 = EightQueens_v2.EightQueens();
        System.out.println("There are " + solutions2.size() + " solutions");
        for (Integer[] l : solutions2) {
            for (int i = 0; i < l.length; i++) {
                //System.out.print("(" + i + "," + l.get(i) + ") ");
                for (int j = 0; j < 8; j++) {
                    if (j == l[i]) {
                        System.out.print("x ");
                    } else {
                        System.out.print("_ ");
                    }
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }
}
