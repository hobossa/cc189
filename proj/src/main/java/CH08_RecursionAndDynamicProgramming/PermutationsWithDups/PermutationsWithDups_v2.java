package CH08_RecursionAndDynamicProgramming.PermutationsWithDups;

import java.util.ArrayList;
import java.util.Hashtable;


// solution from book.
public class PermutationsWithDups_v2 {
    public static ArrayList<String> permutations(String str) {
        Hashtable<Character, Integer> charCounts = new Hashtable<>();   // Hashtable<char, counts>
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        ArrayList<String> permutations = new ArrayList<>();
        permutationHelper(charCounts, "", str.length(), permutations);
        return permutations;
    }

    public static void permutationHelper(Hashtable<Character, Integer> charCounts, String prefix,
                                         int remaining, ArrayList<String> permutations) {
        // Base case. Permutation has been completed
        if (remaining == 0) {
            permutations.add(prefix);
            return;
        }

        for (Character ch: charCounts.keySet()) {
            int count = charCounts.get(ch);
            if (count > 0) {
                charCounts.put(ch, count-1);
                permutationHelper(charCounts, prefix + ch, remaining-1, permutations);
                charCounts.put(ch, count);
            }
        }

    }
}
