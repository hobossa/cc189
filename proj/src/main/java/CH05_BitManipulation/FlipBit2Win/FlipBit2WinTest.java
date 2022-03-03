package CH05_BitManipulation.FlipBit2Win;

// You have an integer and you can flip exactly one bit from a 0 to a 1. Write code to find the length of the
// longest sequence of 1s you could create.

// EXAMPLE
// Input:   1775 (or: 11011101111)
// Output:  8
// Hints: #159, #226, #314, #352

public class FlipBit2WinTest {
    public static void main(String[] args) {
        // for (int i = 0; i < 16; i++) {
        //     System.out.println(Integer.toBinaryString(i));
        //     int max1 = FlipBit2Win_v1.flipBit2Win(i);
        //     int max2 = FlipBit2Win_v2.flipBit2Win(i);
        //     System.out.println(max1);
        //     System.out.println(max2);
        //     System.out.println();
        // }
        int n = -1;//Integer.MAX_VALUE;
        System.out.println(Integer.toBinaryString(n));
        int max1 = FlipBit2Win_v1.flipBit2Win(n);
        int max2 = FlipBit2Win_v2.flipBit2Win(n);
        System.out.println(max1);
        System.out.println(max2);
    }
}
