package CH08_RecursionAndDynamicProgramming.PowerSet;

// Hint 373, You can also to this by mapping each subset to a binary number. The ith bit could represent
// a "boolean" flag for whether an element is in the set.

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PowerSet_v2 {

    public static ArrayList<Set<Integer>> allSubsets(Set<Integer> set) {
        assert(set.size() <= 32);
        return allSubsets(new ArrayList<>(set));
    }


    private static ArrayList<Set<Integer>> allSubsets(ArrayList<Integer> set) {
        ArrayList<Set<Integer>> subsets = new ArrayList<>();
        int max = 1 << set.size();
        for (int i = 0; i < max; i++) {
            subsets.add(convertIntToSet(i, set));
        }
        return subsets;
    }

    private static Set<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
        HashSet<Integer> subset = new HashSet<>();
        for (int i = 0; i < set.size(); i++) {
            if ((x & (1<<i)) != 0) {
                subset.add(set.get(i));
            }
        }
        return subset;
    }
}
