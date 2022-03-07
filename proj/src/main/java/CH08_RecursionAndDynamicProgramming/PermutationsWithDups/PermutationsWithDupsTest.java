package CH08_RecursionAndDynamicProgramming.PermutationsWithDups;

// Write a method to compute all permutations of a string whose characters
// are not necessarily unique. The list of permutations should not have duplicates.
// Hints:#161, #190, #222, #255

// Brute force: One simple way of handling this problem is to do the same work to check if a permutation has
// been created before and then, if not, add it to the list. A simple hash table will do the trick here.
// This solution will take O(n!) time in the worst case (and, in fact, in all cases).

// PermutationsWithDups_v1 is a better solution which count the character first.

import CH08_RecursionAndDynamicProgramming.PermutationsWithoutDups.PermutationsWithoutDups_v1;

import java.util.ArrayList;
import java.util.Hashtable;

public class PermutationsWithDupsTest {

    public static void main(String[] args) {
        String str = "abbc";

        ArrayList<String> permutations1 = PermutationsWithDups_v1.permutations(str);
        System.out.println("There are " + permutations1.size() + " permutations of " + str +".");
        for(String s : permutations1) {
            System.out.println(s);
        }
        System.out.println();

        ArrayList<String> permutations2 = PermutationsWithDups_v2.permutations(str);
        System.out.println("There are " + permutations1.size() + " permutations of " + str +".");
        for(String s : permutations2) {
            System.out.println(s);
        }
        System.out.println();
    }
}
