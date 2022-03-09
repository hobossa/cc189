package CH08_RecursionAndDynamicProgramming.Parens;

// Implement an algorithm to print all valid (e.g., properly opened and closed) combinations
// of n pairs of parentheses.
// EXAMPLE
// Input: 3
// Output: ( ( () ) ) , ( () () ) , ( () ) () , () ( () ) , () () ()
// Hints: #138, #174, #187, #209, #243, #265, #295

import java.util.ArrayList;
import java.util.Set;

public class ParensTest {
    public static void main(String[] args) {
        Set<String> parentheses = Parens_v1.pairsOfParentheses(3);
        for (String str : parentheses) {
            System.out.println(str);
        }

        System.out.println();
        ArrayList<String> list = Parens_v2.pairsOfParentheses(3);
        for( String str: list) {
            System.out.println(str);
        }
    }
}
