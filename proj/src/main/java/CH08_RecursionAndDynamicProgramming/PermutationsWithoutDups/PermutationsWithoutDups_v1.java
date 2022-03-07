package CH08_RecursionAndDynamicProgramming.PermutationsWithoutDups;

import jdk.dynalink.beans.StaticClass;

import java.util.ArrayList;

// Approach version 1: Building from permutations of first n-1 characters.
public class PermutationsWithoutDups_v1 {

    // Tail Recursion approach
    public static ArrayList<String> permutations(String str) {
        ArrayList<String> result = new ArrayList<>();

        ArrayList<StringBuilder> temp = permutationsHelper(str);
        for (StringBuilder sb : temp) {
            result.add(sb.toString());
        }

        return result;
    }

    private static ArrayList<StringBuilder> permutationsHelper(String str) {
        ArrayList<StringBuilder> permutations = new ArrayList<>();
        if (str.length() >0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str.charAt(0));
            permutations.add(stringBuilder);
            permutationsHelper(permutations, str, 1);
        }
        return permutations;
    }

    private static void permutationsHelper(ArrayList<StringBuilder> permutations, String str, int index) {
        if (index == str.length()) {
            return;
        }
        char c = str.charAt(index);
        int n = permutations.size();
        for (int i = 0; i < n; i++) {
            StringBuilder stringBuilder = permutations.get(i);
            for (int j = 0; j < stringBuilder.length(); j++) {
                StringBuilder temp = new StringBuilder(stringBuilder);
                temp.insert(j, c);
                permutations.add(temp);
            }
            stringBuilder.append(c);
        }

        permutationsHelper(permutations, str, index+1);
    }
}
