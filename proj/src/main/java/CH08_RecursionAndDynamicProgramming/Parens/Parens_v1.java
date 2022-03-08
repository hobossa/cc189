package CH08_RecursionAndDynamicProgramming.Parens;

import java.util.HashSet;
import java.util.Set;

public class Parens_v1 {
    private static final char L = '(';
    private static final String P = "()";

    public static Set<String> pairsOfParentheses(int n) {
        Set<String> parentheses = new HashSet<>();
        if (0 == n) {
            parentheses.add("");
            return parentheses;
        }
        for (String str : pairsOfParentheses(n - 1)) {
            parentheses.add(P + str);
            for (int i = 0; i < str.length(); i++) {
                StringBuilder sb = new StringBuilder(str);
                if (str.charAt(i) == L) {
                    parentheses.add(sb.insert(i+1, P).toString());
                }
            }
        }
        return parentheses;
    }
}
