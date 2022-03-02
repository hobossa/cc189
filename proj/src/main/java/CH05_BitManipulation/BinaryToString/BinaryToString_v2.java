package CH05_BitManipulation.BinaryToString;

public class BinaryToString_v2 {
    static public final String ERR = "ERROR.";
    static final int MAX_CHARS = 32;

    public static String binary2String(double num) {
        if (num <= 0 || num >= 1) {
            return ERR;
        }

        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        stringBuilder.append(".");
        while (num != 0.0) {
            num = num * 2;
            if (num - 1 >= 0.0) {
                stringBuilder.append("1");
                num = num -1;
            } else {
                stringBuilder.append("0");
            }
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
