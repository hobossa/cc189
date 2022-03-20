package CH08_RecursionAndDynamicProgramming.StackOfBoxes;

// You have a stack of n boxes, with widths w, heights h, and depths d. The boxes
// cannot be rotated and can only be stacked on top of one another if each box in the stack is strictly
// larger than the box above it in width, height, and depth. Implement a method to compute the
// height of the tallest possible stack. The height of a stack is the sum of the heights of each box.
// Hints:#155, #194, #214, #260, #322, #368, #378

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class StackOfBoxesTest {
    private static final int NUM_OF_BOXES = 5;

    public static void main(String[] args) {
        ArrayList<Box> boxes1 = new ArrayList<>();

        for (int i = 0; i < NUM_OF_BOXES; i++) {
            Box temp = createRandomBox();
            //Box temp = new Box(i+10, i+20, i+30);
            System.out.println(temp);
            boxes1.add(temp);
        }

        System.out.println(StackOfBoxes_v1.maxStackHeight(boxes1));
        System.out.println(StackOfBoxes_v2.maxStackHeight(boxes1));
        System.out.println(StackOfBoxes_v3.maxStackHeight(boxes1));
    }

    private static Box createRandomBox() {
        return new Box(ThreadLocalRandom.current().nextInt(10, 100),
                ThreadLocalRandom.current().nextInt(10, 100),
                ThreadLocalRandom.current().nextInt(10, 100));
    }
}
