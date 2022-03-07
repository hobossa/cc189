package CH08_RecursionAndDynamicProgramming.PermutationsWithoutDups;

// Write a method to compute all permutations of a string of unique characters.
// Hints:#150, #185, #200, #267, #278, #309, #335, #356

// FOR EXAMPLE
// INPUT: "abc"
// OUTPUT: {"abc", "acb", "bac", "bca", "cab", "cba"}

import java.util.ArrayList;

public class PermutationsWithoutDupsTest {
    public static void main(String[] args) {
        String str = "abcd";

        ArrayList<String> permutations = PermutationsWithoutDups_v1.permutations(str);
        System.out.println("There are " + permutations.size() + " permutations of " + str +".");
        for(String s : permutations) {
            System.out.println(s);
        }
    }
}
