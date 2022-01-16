package ArraysAndStrings;

// Implement a method to perform basic string compression using the counts of repeated characters.
// For example, the string aabcccccaaa would become a2b1c5a3. If the "compressed" String would not
// become smaller than the original string, your method should return the origianl string. You can
// assume the String has only uppercase and lowercase Letters(a-z).
// Hints: #92, #110

public class StringCompression {

    // time O(N), space O(N)?
    public static String compress_v1(String str) {
        StringBuilder strBuilder = new StringBuilder();
        char ch ='\0';
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (ch != str.charAt(i)) {
                if (count != 0) {
                    strBuilder.append(ch);
                    strBuilder.append(count);
                }
                ch = str.charAt(i);
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 0) {
            strBuilder.append(ch);
            strBuilder.append(count);
        }
        return strBuilder.length() < str.length() ? strBuilder.toString() : str;
    }

    // same idea with v1, but better coding.
    public static String compress_v2(String str) {
        StringBuilder strBuilder = new StringBuilder();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count++;
            char c = str.charAt(i);
            if (i + 1 >= str.length() || c != str.charAt(i+1)) {
                // reach the end or the next character is different.
                strBuilder.append(c);
                strBuilder.append(count);
                count = 0;
            }
        }
        return strBuilder.length() < str.length() ? strBuilder.toString() : str;
    }

    // solutions
    // solution 1
    public static String compress_s1(String str) {
        String compressedString = "";
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString += "" + str.charAt(i) + countConsecutive;
                countConsecutive = 0;
            }
        }
        return compressedString.length() < str.length() ? compressedString : str;
    }

    // solution 2,
    // using StringBuilder
    public static String compress_s2(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    // solution 3,
    // calculate the length of compressed string first,
    // if it is longer than the original string, return the original string without doing the real compression.
    public static String compress_s3(String str) {
        int finalLength = countCompression(str);
        if (finalLength >= str.length()) return str;

        StringBuffer compressed = new StringBuffer(finalLength); // initialize capacity
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.toString();
    }

    public static int countCompression(String str) {
        int compressedLength = 0;
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedLength += 1 + String.valueOf(countConsecutive).length();
                countConsecutive = 0;
            }
        }
        return compressedLength;
    }
    // test
    public static void main(String[] args) {
        //String str = "caaaaabbbbaaaabbddc";
        String str = "abbb";
        System.out.println(str);
        System.out.println(compress_v1(str));
        System.out.println(compress_v2(str));
        System.out.println(compress_s1(str));
        System.out.println(compress_s2(str));
        System.out.println(compress_s3(str));
    }
}
