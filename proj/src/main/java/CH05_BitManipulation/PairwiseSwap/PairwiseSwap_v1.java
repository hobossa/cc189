package CH05_BitManipulation.PairwiseSwap;

public class PairwiseSwap_v1 {
    private static int oddMask;
    private static int evenMask;

    static {
        oddMask = 0;
        evenMask = 0;
        int n = 0;
        while (n <= 30) {
            oddMask = oddMask | (1 << n);
            n++;
            evenMask = evenMask | (1 << n);
            n++;
        }
    }

    public static int swap(int n) {
        // System.out.println(Integer.toBinaryString(oddMask));
        // System.out.println(Integer.toBinaryString(evenMask));

        return ((n & oddMask) << 1) | ( (n & evenMask) >>> 1);
    }
}
