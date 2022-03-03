package CH05_BitManipulation;

// Hints: #151, #202, #261, #302, #346, #372, #383, #398

public class Debugger {
    public static void main(String[] args) {

        for (int n = 0; n < 100; n++) {
            // Explain what the following code does

            System.out.println(Integer.toBinaryString(n));
            if ((n & (n - 1)) == 0) {
                System.out.println("There is at most 1 bit is 1 in " + n);
            }
        }

        // System.out.println();
        // //int i = Integer.MIN_VALUE;
        // int i = -123;
        // System.out.println(i);
        // System.out.println(Integer.toBinaryString(i));
        // System.out.println(i >> 1);
        // System.out.println(Integer.toBinaryString(i >> 1));
        // System.out.println(i >>> 1);
        // System.out.println(Integer.toBinaryString(i >>> 1));
        // System.out.println(i << 1);
        // System.out.println(Integer.toBinaryString(i << 1));

    }
}
