package CH08_RecursionAndDynamicProgramming.PowerSet;

// Write a method to return all subsets of a set.
// Hints: #273, #290, #338, #354, #373

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class PowerSetTest {

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(i);
        }

        ArrayList<Set<Integer>> subsets1 = PowerSet_v1.allSubsets(set);
        for (Set<Integer> subset : subsets1) {
            System.out.println(subset);
        }

        System.out.println("////////");
        ArrayList<Set<Integer>> subsets2 = PowerSet_v2.allSubsets(set);
        for (Set<Integer> subset : subsets2) {
            System.out.println(subset);
        }
    }
}
