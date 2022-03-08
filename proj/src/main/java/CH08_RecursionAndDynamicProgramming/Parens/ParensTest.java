package CH08_RecursionAndDynamicProgramming.Parens;

// Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
// of n pairs of parentheses.
// EXAMPLE
// Input: 3
// Output: ( ( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()
// Hints: #138, #174, #187, #209, #243, #265, #295

import java.util.Set;

public class ParensTest {
    public static void main(String[] args) {
        Set<String> parentheses = Parens_v1.pairsOfParentheses(4);
        for (String str : parentheses) {
            System.out.println(str);
        }
    }
}
