package CH01_ArraysAndStrings;

// Implement an algorithm to determine if a string has all unique characters.
// What if you cannot use additional data structures?
// Hints
// #44, Try hash table
// #117, Could a bit vector be useful
// #132, Can you solve it in O(N log N) time? What might a solution like that look like?

import java.util.Arrays;
import java.util.BitSet;
import java.util.Hashtable;

public class IsUnique {

    // the first idea I got is sorting the characters then finding if there are same characters.
    // time O(N log N), space O(N)
    public static boolean isUnique_v1(String str) {
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray); // time O(N log N)
        for (int i = 1; i < tempArray.length; i++) {    // time O(N)
            if (tempArray[i - 1] == tempArray[i]) {
                return false;
            }
        }
        return true;
    }

    // Hint, try Hashtable
    // time O(N) / O(1)?.
    public static boolean isUnique_v2(String str) {
        Hashtable<Character, Boolean> tempHashtable = new Hashtable<>();
        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            if (tempHashtable.containsKey(key)) {
                return false;
            } else {
                tempHashtable.put(key, true);
            }
        }
        return true;
    }

    // Hint, bit vector (BitSet in Java)
    // assume elements in str are characters
    // time O(1)
    public static boolean isUnique_v3(String str) {
        BitSet tempBSet = new BitSet(256);
        for (int i = 0; i < str.length(); i++) {
            int ascValue = str.charAt(i);
            if (tempBSet.get(ascValue)) {
                return false;
            }
            tempBSet.set(ascValue);
        }
        return true;
    }

    // solutions from book
    public static boolean isUnique_s1(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    public static boolean isUnique_s2(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
    //


    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        isUnique_v3(words[1]);
        for (String word : words) {
            System.out.println(word);
            System.out.println(
                    isUnique_v1(word) + " : " +
                    isUnique_v2(word) + " : " +
                    isUnique_v3(word) + " : " +
                    isUnique_s1(word) + " : " +
                    isUnique_s2(word));
        }
    }
}
