package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

import java.util.ArrayList;
import java.util.Hashtable;

public class StackOfBoxes_v3 {
    public static int maxStackHeight(ArrayList<Box> boxes) {
        ArrayList<Box> sortedBoxes = new ArrayList<>(boxes);
        sortedBoxes.sort((Box o1, Box o2) -> o2.getW() - o1.getW());
        Hashtable<Integer, Integer> memo = new Hashtable<>();   // <bottomIndex, maxHeight>

        int maxHeight = 0;


        return maxHeight;
    }
}
