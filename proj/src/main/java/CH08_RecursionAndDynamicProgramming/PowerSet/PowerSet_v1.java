package CH08_RecursionAndDynamicProgramming.PowerSet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PowerSet_v1 {

    // Recursion approach
    public static ArrayList<Set<Integer>> allSubsets(Set<Integer> set) {
        ArrayList<Set<Integer>> subsets = new ArrayList<>();
        subsets.add(new HashSet<>());   // add an empty set. an empty set is the subset of any set.
        allSubSets(new HashSet<>(set), subsets);   // new HashSet<>(set) to prevent from modifying argument.
        return subsets;
    }

    private static void allSubSets(Set<Integer> set, ArrayList<Set<Integer>> subsets) {
        if (set.size() == 0) {
            return;
        }
        Integer cur = set.iterator().next();

        int n = subsets.size();
        for (int i = 0; i < n; i++) {
            HashSet<Integer> temp = new HashSet<>(subsets.get(i));
            temp.add(cur);
            subsets.add(temp);
        }

        set.remove(cur);
        allSubSets(set, subsets);
    }
}
