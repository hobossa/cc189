package CH08_RecursionAndDynamicProgramming.EightQueens;


import Common.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class EightQueens_v1 {
    public static ArrayList<ArrayList<Integer>> EightQueens() {
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        // the array used to record the col positions of queens.
        ArrayList<Integer> colPosition = new ArrayList<>();
        // used to check if there are any queen on the same col.
        HashSet<Integer> colSet = new HashSet<>();
        // used to check if there ary any queen on the topLeft-bottomRight diagonal
        HashSet<Integer> diagSet = new HashSet<>();
        // used to check if there ary any queen on the topRight-bottomLeft diagonal
        HashSet<Integer> diagSetR = new HashSet<>();

        EightQueensHelper(0, solutions, colPosition, colSet, diagSet, diagSetR);

        return solutions;
    }


    @SuppressWarnings("unchecked")
    private static void EightQueensHelper(int row, ArrayList<ArrayList<Integer>> solutions,
                                         ArrayList<Integer> colPosition, HashSet<Integer> colSet,
                                         HashSet<Integer> diagSet, HashSet<Integer> diagSetR) {
        for (int i = 0; i < 8; i++) {
            if (colSet.contains(i) // there is another queen on the same col
                    || diagSet.contains(row - i)  // there is another queen on the same topLeft-bottomRight diagonal
                    || diagSetR.contains(row + i)) { // there is another queen on the same topRight-bottomLeft diagonal
                continue;
            }

            colPosition.add(i);
            colSet.add(i);
            diagSet.add(row - i);
            diagSetR.add(row + i);
            if (row + 1 >= 8) {
                // Get a solution.
                solutions.add((ArrayList<Integer>) colPosition.clone());
            } else {
                EightQueensHelper(row + 1, solutions, colPosition, colSet, diagSet, diagSetR);
            }
            colPosition.remove(colPosition.size() - 1); // remove the last element
            colSet.remove(i);
            diagSet.remove(row - i);
            diagSetR.remove(row + i);
        }
    }
}
