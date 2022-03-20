package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

// similar to solution 1, but using memo to optimize
public class StackOfBoxes_v2 {

    public static int maxStackHeight(ArrayList<Box> boxes) {
        ArrayList<Box> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((Box o1, Box o2) -> o2.getW() - o1.getW());
        //Hashtable<Integer, Integer> memo = new Hashtable<>();   // <bottomIndex, maxHeight>
        int[] memo = new int[boxes.size()];

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = maxStackHeightHelper(sortedBoxes, i, memo);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    private static int maxStackHeightHelper(ArrayList<Box> boxes, int bottomIndex, int[] memo) {
        if (bottomIndex < boxes.size() && memo[bottomIndex] > 0) {
            return memo[bottomIndex];
        }
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex+1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = maxStackHeightHelper(boxes, i, memo);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.getH();
        memo[bottomIndex] = maxHeight;
        return maxHeight;
    }
}
