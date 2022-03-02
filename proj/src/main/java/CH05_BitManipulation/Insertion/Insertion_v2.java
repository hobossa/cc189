package CH05_BitManipulation.Insertion;

public class Insertion_v2 {
    public static int insertion(int n, int m, int i, int j) {
        // Validation
        if (i > j || i < 0 || j >= 32) {
            return 0;
        }

        int mask = -1 << i;
        //System.out.println(Integer.toBinaryString(mask));
        if (j < 31) {
            int mask2 = ((1 << (j + 1)) - 1);
            //System.out.println(Integer.toBinaryString(mask2));
            mask = mask & mask2;
        }
        mask = ~mask;
        //System.out.println(Integer.toBinaryString(mask));

        return n & mask | (m << i);
    }
}
