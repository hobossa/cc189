package CH05_BitManipulation.Conversion;

// Write a function to determine the number of bits you would need to flip to convert integer A to integerB.

// EXAMPLE
// Input:   29 (or: 11101), 15 (or: 01111)
// Output:  2

// Hints: #336, #369


// ask the interviewer whether the input integers are positive.
public class ConversionTest {
    public static void main(String[] args) {
        int m = -29;
        int n = 15;
        System.out.println(Integer.toBinaryString(m));
        System.out.println(Integer.toBinaryString(n));
        System.out.println(Conversion_v1.bitFlipRequired(m, n));
        System.out.println(Conversion_v2.bitFlipRequired(m, n));
        System.out.println(Conversion_v3.bitFlipRequired(m, n));
    }
}
