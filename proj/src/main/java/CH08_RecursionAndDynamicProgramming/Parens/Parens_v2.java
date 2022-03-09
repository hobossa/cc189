package CH08_RecursionAndDynamicProgramming.Parens;

// The parens_v1 is noe efficient. We waste a lot of time coming up with th duplicate
// strings.
// To avoid this duplicate string issue by building the string from scratch.
// Under this approach, we add left and right parens, as long as our expression stays
// valid.

// On each recursive call, we have the index for a particular character in the string.
// We need to select either a left or a right paren. When can we use a left paren, and
// when can we use a right paren?
// 1. Left Paren: As long as we haven't used up all the left parentheses, we can always
// insert a left paren.
// 2. Right Paren: We can insert a right paren as long as it won't lead to a syntax error.
// When will we get a syntax error? We will get a syntax error if there are more right
// parentheses than left.
// So, we simply keep track of the number of left and right parentheses allowed. If there
// are left parens remaining, we'll insert a left paren and recurse. If there are more
// right parens remaining than left (i.e., if there are more left parens in use than right
// parens), then we'll insert a right paren and recurse.

import Common.Util;

import java.util.ArrayList;
import java.util.Arrays;

public class Parens_v2 {
    private static final char L = '(';
    private static final char R = ')';
    //private static final String P = "()";

    public static ArrayList<String> pairsOfParentheses(int n) {
        char[] buff = new char[n * 2];
        ArrayList<String> list = new ArrayList<>();
        addParen(list, n, n, buff, 0);
        return list;
    }

    public static void addParen(ArrayList<String> list, int leftRem, int rightRem,
                                char[] buff, int index) {
        if (leftRem < 0 || rightRem < leftRem) {
            // invalid state
            return;
        }

        if (leftRem == 0 && rightRem == 0) {
            list.add((String.copyValueOf(buff)));
        } else {
            buff[index] = L;
            addParen(list, leftRem - 1, rightRem, buff, index + 1);

            buff[index] = R;
            addParen(list, leftRem, rightRem - 1, buff, index + 1);
        }
    }
}
