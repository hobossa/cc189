package CH05_BitManipulation.Insertion;

// You are given two 32-bit numbers, N and M, and two bit positions, i and j. Write a method to insert M into N
// such that M starts at bit j and ends at bit i. You can assume that the bits j through i have enough space to
// fit all of M. That is, if M = 10011, you can assume that there ae at least 5 bits between j and i. You would
// not, for example, have j = 3 and i = 2, because M could not fully fit between bit 3 and bit 2.

// EXAMPLE
// Input:   N = 10000000000, M = 10011, i = 2, j = 6
// Output:  N = 10001001100

// Hints: #137,, #169, #215


public class InsertionTest {
    public static void main(String[] args) {
        int a = ~23423;
        System.out.println(Integer.toBinaryString(a));
        int b = 5;
        System.out.println(Integer.toBinaryString(b));
        int c = Insertion_v1.insertion(a, b, 29, 31);
        System.out.println(Integer.toBinaryString(c));

        System.out.println();

        int c2 = Insertion_v2.insertion(a, b, 3, 5);
        System.out.println(Integer.toBinaryString(c2));
    }
}
