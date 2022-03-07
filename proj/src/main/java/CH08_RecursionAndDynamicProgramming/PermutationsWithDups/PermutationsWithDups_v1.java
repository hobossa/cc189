package CH08_RecursionAndDynamicProgramming.PermutationsWithDups;

import java.util.ArrayList;
import java.util.Hashtable;

public class PermutationsWithDups_v1 {

    public static ArrayList<String> permutations(String str) {
        Hashtable<Character, Integer> charCounts = new Hashtable<>();   // Hashtable<char, counts>
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            charCounts.put(ch, charCounts.getOrDefault(ch, 0) + 1);
        }

        ArrayList<String> result = new ArrayList<>();
        ArrayList<StringBuilder> temp = permutationsHelper(charCounts, str.length());
        for (StringBuilder sb : temp) {
            result.add(sb.toString());
        }
        return result;
    }

    public static ArrayList<StringBuilder> permutationsHelper(Hashtable<Character, Integer> charCounts, int remaining) {
        ArrayList<StringBuilder> permutations = new ArrayList<>();
        if (remaining <= 0) {
            permutations.add(new StringBuilder(""));
            return permutations;
        }
        for (Character ch : charCounts.keySet()) {
            int count = charCounts.get(ch);
            if (count > 0) {
                charCounts.put(ch, count-1);
                for(StringBuilder sb : permutationsHelper(charCounts, remaining-1)) {
                    sb.insert(0, ch);
                    permutations.add(sb);
                }
                charCounts.put(ch, count);
            }
        }
        return permutations;
    }
}
