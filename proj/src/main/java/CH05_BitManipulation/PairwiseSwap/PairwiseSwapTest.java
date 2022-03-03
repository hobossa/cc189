package CH05_BitManipulation.PairwiseSwap;

// Write a program to swap odd and even bits in an integer with as few instructions as possible
// (e.g., bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, and so on).
// Hints: #145, #248, #328, #355

public class PairwiseSwapTest {
    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            int s = PairwiseSwap_v1.swap(i);
            assert (s == PairwiseSwap_v2.swap(i));
            System.out.println("" + i + "-" + s);
            System.out.println(Integer.toBinaryString(i));
            System.out.println(Integer.toBinaryString(s));
        }
    }
}
