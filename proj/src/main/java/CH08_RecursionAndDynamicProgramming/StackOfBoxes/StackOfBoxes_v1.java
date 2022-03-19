package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;

public class StackOfBoxes_v1 {
    public static int maxStackHeight(ArrayList<Box> boxes) {
        ArrayList<Box> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((Box o1, Box o2) -> o2.getW() - o1.getW());

        int maxHeight = 0;
        for (int i = 0; i < boxes.size(); i++) {
            int height = maxStackHeightHelper(sortedBoxes, i);
            maxHeight = Math.max(maxHeight, height);
        }

        return maxHeight;
    }

    private static int maxStackHeightHelper(ArrayList<Box> boxes, int bottomIndex) {
        Box bottom = boxes.get(bottomIndex);
        int maxHeight = 0;
        for (int i = bottomIndex+1; i < boxes.size(); i++) {
            if (boxes.get(i).canBeAbove(bottom)) {
                int height = maxStackHeightHelper(boxes, i);
                maxHeight = Math.max(height, maxHeight);
            }
        }
        maxHeight += bottom.getH();
        return maxHeight;
    }
}
