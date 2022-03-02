package CH05_BitManipulation.BinaryToString;

// Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print the binary representation.
// If the number cannot be represented accurately in binary with at most 32 characters, print "ERROR."

// Hints: #143, #167, #173, #268, #297

public class BinaryToStringTest {

    public static void main(String[] args) {
        System.out.println(BinaryToString_v1.binary2String(0.625));
        System.out.println(BinaryToString_v1.binary2String(1.0/4 + 1.0 /16 + 1.0 /64 + 1.0 / 128 + 1.0 / 512));
        System.out.println(BinaryToString_v2.binary2String(0.625));
        System.out.println(BinaryToString_v2.binary2String(1.0/4 + 1.0 /16 + 1.0 /64 + 1.0 / 128 + 1.0 / 512));

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = BinaryToString_v1.binary2String(num);
            String binary2 = BinaryToString_v2.binary2String(num);
            if (!binary.equals("ERROR.") || !binary2.equals("ERROR.")) {
                System.out.println(num + " : " + binary + " " + binary2);
            }
        }

    }
}
