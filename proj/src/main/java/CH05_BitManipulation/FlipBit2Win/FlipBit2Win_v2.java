package CH05_BitManipulation.FlipBit2Win;

public class FlipBit2Win_v2 {
    public static int SEQUENCE_LENGTH = 32;

    // better solution than version1,
    // space O(1), and clear coding.
    public static int flipBit2Win(int n) {
        int flipPos = -1;   // the position that we flip the bit to 1.
        int max = 0;
        int count = 0;
        for (int i = 0; i < SEQUENCE_LENGTH; i++) {
            int t = (1 << i) & n;
            if (t != 0) {
                count++;
            } else {
                if (count > max) {
                    max = count;
                }
                // flip the current bit, and update count
                count = i - flipPos;
                flipPos = i;
            }
        }
        // the following code is important, otherwise, we will have no chance to update the max, if we flip
        // the last bit in the above loop.
        if (count > max) {
            max = count;
        }

        return max;
    }
}
