package CH05_BitManipulation.FlipBit2Win;

// You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the
// longest sequence of 1s you could create.

// EXAMPLE
// Input:   1775 (or: 11011101111)
// Output:  8
// Hints: #159, #226, #314, #352

public class FlipBit2WinTest {
    public static void main(String[] args) {
        for (int i = 0; i < 32; i++) {
            System.out.println(Integer.toBinaryString(i));
            int max = FlipBit2Win_v1.flipBit2Win(i);
            System.out.println(max);
            System.out.println();
        }
    }
}
