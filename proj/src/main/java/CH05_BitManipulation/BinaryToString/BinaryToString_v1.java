package CH05_BitManipulation.BinaryToString;

public class BinaryToString_v1 {
    static public final String ERR = "ERROR.";
    static final int MAX_CHARS = 32;

    public static String binary2String(double num) {
        if (num <= 0 || num >= 1) {
            return ERR;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        stringBuilder.append(".");

        int n = 2;
        while (num != 0.0) {
            if (num >= 1.0 / n) {
                stringBuilder.append("1");
                num = num - 1.0 / n;
            } else {
                stringBuilder.append("0");
            }

            n *= 2;
            count++;
            if (count > MAX_CHARS) {
                break;
            }
        }

        if (count > MAX_CHARS) {
            return ERR;
        }
        return stringBuilder.toString();
    }
}
