package ArraysAndStrings;

// There are three types of edits that can be performed on strings: insert a character,
// remove a character, or replace a character. Given two strings, write a function to
// check if they are one edit(or zero edits) away.
// EXAMPLE
// plae,    ple     -> ture
// pales,   pale    -> true
// pale,    bale    -> true
// pale,    bake    -> false
// Hints: #23, #97, #130

public class OneWay {

    // time O(N), space O(1)
    public static boolean isOneEditWay_v1(String strA, String strB) {
        int lenA = strA.length();
        int lenB = strB.length();
        if (Math.abs(lenA - lenB) > 1) {
            return false;
        } else if (lenA == lenB) {
            int countDiff = 0;
            for (int i = 0; i < lenA; i++) {
                if (strA.charAt(i) != strB.charAt(i)) {
                    countDiff++;
                    if (countDiff > 1) {
                        return false;
                    }
                }
            }
            return true;
        } else {  //
            int countJump = 0;
            int j = 0;
            int i = 0;
            while (i < lenA && j < lenB) {
                if (strA.charAt(i) == strB.charAt(j)) {
                    i++;
                    j++;
                } else if (i < lenA - 1 && strA.charAt(i + 1) == strB.charAt(j)) {
                    i += 2;
                    j++;
                    countJump++;
                } else if (j < lenB - 1 && strA.charAt(i) == strB.charAt(j + 1)) {
                    i++;
                    j += 2;
                    countJump++;
                } else {
                    return false;
                }
                if (countJump > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // simply the code refer to solution 2
    public static boolean isOneEditWay_v2(String strA, String strB) {
        if (Math.abs(strA.length() - strB.length()) > 1) {
            return false;
        }
        // get the longer and shorter string
        String s1 = strA.length() > strB.length() ? strA : strB;
        String s2 = strA.length() > strB.length() ? strB : strA;

        boolean foundDiff = false;
        int i = 0, j = 0;
        while (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                if (foundDiff) {
                    return false;
                }
                foundDiff = true;
                if (s1.length() == s2.length()) {   // replace
                    i++;
                    j++;
                } else {    // delete or insert
                    i++;
                }
            }
        }
        return true;
    }

    // solutions from book
    // solution 1
    public static boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }

                foundDifference = true;
            }
        }
        return true;
    }

    /* Check if you can insert a character into s1 to make s2. */
    public static boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public static boolean isOneEditWay_s1(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    // solution 2
    public static boolean isOneEditWay_s2(String first, String second) {
        /* Length checks. */
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        /* Get shorter and longer string.*/
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                /* Ensure that this is the first difference found.*/
                if (foundDifference) return false;
                foundDifference = true;
                if (s1.length() == s2.length()) { // On replace, move shorter pointer
                    index1++;
                }
            } else {
                index1++; // If matching, move shorter pointer
            }
            index2++; // Always move pointer for longer string
        }
        return true;
    }

    // test

    public static void main(String[] args) {
        // strA, strB, expected
        String[][] tests = {
                {"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}
        };

        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            System.out.println("\"" + test[0] + "\" - \"" + test[1] + "\" , expected: " + test[2] + " :" +
                    " v1 - " + isOneEditWay_v1(test[0], test[1]) + " :" +
                    " v2 - " + isOneEditWay_v2(test[0], test[1]) + " :" +
                    " s1 - " + isOneEditWay_s1(test[0], test[1]) + " :" +
                    " s2 - " + isOneEditWay_s2(test[0], test[1]));
        }
    }
}
