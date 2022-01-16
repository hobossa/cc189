package ArraysAndStrings;

// Assume you have a method isSubstring which checks if one word is a substring of another.
// Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to
// isSubstring (e.g., "waterbottle" is a rotation of "erbottlewat").
// Hint: #34, #88, #104

public class StringRotation {

    public static boolean isSubstring(String str, String strSub) {
        return str.contains(strSub);
    }

    // time O()? depends on the implement of isSubstring. it can be O(N) if it was based on KMP algorithm
    // space O(N)
    public static boolean isRotation_v1(String strA, String strB) {
        if (0 == strA.length() || strA.length() != strB.length()) {
            return false;
        }
        String strTemp = strA + strA;
        // return strB isSubstring of strTemp;
        return isSubstring(strTemp, strB);
    }

    // test
    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation_v1(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
