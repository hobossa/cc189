package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Hashtable;

public class StackOfBoxes_v3 {
    public static int maxStackHeight(ArrayList<Box> boxes) {
        ArrayList<Box> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((Box o1, Box o2) -> o2.getW() - o1.getW());
        int[] memo = new int[boxes.size()];
        return maxStackHeightHelper(sortedBoxes, null, 0, memo);
    }

    private static int maxStackHeightHelper(ArrayList<Box> boxes, Box bottom, int offset, int[] memo) {
        if (offset >= boxes.size()) {
            return 0;       // base case
        }

        // height with this new bottom
        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;
        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (memo[offset] == 0) {
                memo[offset] = maxStackHeightHelper(boxes, newBottom, offset+1, memo);
                memo[offset] += newBottom.getH();
            }
            heightWithBottom = memo[offset];
        }

        // height without this new bottom
        int heightWithoutBottom = maxStackHeightHelper(boxes, bottom, offset+1, memo);

        // return better of two options
        return Math.max(heightWithBottom, heightWithoutBottom);
    }
}
