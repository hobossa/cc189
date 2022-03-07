package CH08_RecursionAndDynamicProgramming.PermutationsWithoutDups;

import java.util.ArrayList;

// Approach version 2: Building from permutations of all n-1 character substring.
public class PermutationsWithoutDups_v2 {

    public static ArrayList<String> permutations(String str) {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<StringBuilder> temp = permutationsHelper(new StringBuilder(str));
        for (StringBuilder sb : temp) {
            result.add(sb.toString());
        }

        return result;
    }

    private static ArrayList<StringBuilder> permutationsHelper(StringBuilder str) {
        ArrayList<StringBuilder> permutations = new ArrayList<>();
        int len = str.length();
        if (len <=0) {
            permutations.add(new StringBuilder(""));
            return permutations;
        } else if (len == 1) {
            permutations.add(str);
            return permutations;
        }

        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            StringBuilder temp = new StringBuilder(str);
            temp.deleteCharAt(i);
            for ( StringBuilder sb : permutationsHelper(temp)) {
                permutations.add(sb.insert(0,c));
            }
        }
        return permutations;
    }
}
