package CH05_BitManipulation.PairwiseSwap;

public class PairwiseSwap_v2 {
    private static final int oddMask = 0x55555555;
    private static final int evenMask = 0xaaaaaaaa;

    public static int swap(int n) {
        // System.out.println(Integer.toBinaryString(oddMask));
        // System.out.println(Integer.toBinaryString(evenMask));

        return ((n & oddMask) << 1) | ( (n & evenMask) >>> 1);
    }
}
