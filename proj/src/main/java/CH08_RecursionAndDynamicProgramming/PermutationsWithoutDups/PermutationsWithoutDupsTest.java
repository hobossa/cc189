package CH08_RecursionAndDynamicProgramming.PermutationsWithoutDups;

// Write a method to compute all permutations of a string of unique characters.
// Hints:#150, #185, #200, #267, #278, #309, #335, #356

// FOR EXAMPLE
// INPUT: "abc"
// OUTPUT: {"abc", "acb", "bac", "bca", "cab", "cba"}

import java.util.ArrayList;

public class PermutationsWithoutDupsTest {
    public static void main(String[] args) {
        String str = "abc";

        ArrayList<String> permutations1 = PermutationsWithoutDups_v1.permutations(str);
        System.out.println("There are " + permutations1.size() + " permutations of " + str +".");
        for(String s : permutations1) {
            System.out.println(s);
        }
        System.out.println();

        ArrayList<String> permutations2 = PermutationsWithoutDups_v2.permutations(str);
        System.out.println("There are " + permutations2.size() + " permutations of " + str +".");
        for(String s : permutations2) {
            System.out.println(s);
        }
    }
}
