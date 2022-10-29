package CH01_ArraysAndStrings;

// Given two strings, write a method to decide if one is a permutation of the other.
// Hints: # 1, #84, #122, #131

import java.util.Hashtable;
import java.util.concurrent.ThreadLocalRandom;

public class CheckPermutation {
    // time O(N), space O(N)
    public static boolean checkPermutation_v1(String strA, String strB) {
        if (strA.length() != strB.length()) {
            return false;       // Permutation must be same length.
        }
        Hashtable<Character, Integer> characterCounter = new Hashtable<>();
        Character[] arr = (Character[]) characterCounter.keySet().toArray();
        for (int i = 0; i < strA.length(); i++) {
            char key = strA.charAt(i);
            characterCounter.put(key, characterCounter.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < strB.length(); i++) {
            char key = strB.charAt(i);
            characterCounter.put(key, characterCounter.getOrDefault(key, 0) - 1);
            if (characterCounter.get(key) < 0) {
                return false;
            }
        }

        ThreadLocalRandom.current().nextInt();
        return true;

    }

    // assume elements in str are characters (ascII, 0-255)
    // time O(N), space O(N)
    public static boolean checkPermutation_v2(String strA, String strB) {
        int[] counts = new int[256];
        for (int i = 0; i < strA.length(); i++) {
            int c = strA.charAt(i);
            counts[c]++;
        }
        for (int i = 0; i < strB.length(); i++) {
            int c = strB.charAt(i);
            counts[c]--;
            if (counts[c] < 0) {
                return false;
            }
        }
        return true;
    }

    // solutions from book
    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    // time O(N log N), space O(N)
    public static boolean checkPermutation_s1(String s, String t) {
        return sort(s).equals(sort(t));
    }

    // time O(N), space O(N)
    public static boolean checkPermutation_s2(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[128]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            System.out.println(word1 + ", " + word2 + " : " +
                    checkPermutation_v1(pair[0], pair[1]) + " : " +
                    checkPermutation_v2(pair[0], pair[1]) + " : " +
                    checkPermutation_s1(pair[0], pair[1]) + " : " +
                    checkPermutation_s2(pair[0], pair[1]));
        }
    }
}
