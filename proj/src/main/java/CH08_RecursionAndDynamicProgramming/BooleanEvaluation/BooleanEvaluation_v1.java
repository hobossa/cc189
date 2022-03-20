package CH08_RecursionAndDynamicProgramming.BooleanEvaluation;


// solution 1, brute force, from left to right choose an operator as the lowest priority operator.
// eg: 1&2|3
// the first operator as the lowest: 1&(2|3)
// the second operator as the lowest: (1&2)|3

import java.util.ArrayList;

// so the chosen operator split the expression (string) to 2 parts (left and right);
public class BooleanEvaluation_v1 {
    public static int countEvaluation(String expression, boolean value) {
        if (expression.length() == 1) {
            return BooleanEvaluationUtil.char2Boolean(expression.charAt(0)) == value ? 1 : 0;
        }
        int total = 0;

        for (int i = 1; i < expression.length(); i += 2) {
            char operator = expression.charAt(i);
            String left = expression.substring(0, i);
            String right = expression.substring(i + 1, expression.length());
            // the following 4 lines data can be memorized.
            int leftTrue = countEvaluation(left, true);
            int leftFalse = countEvaluation(left, false);
            int rightTrue = countEvaluation(right, true);
            int rightFalse = countEvaluation(right, false);

            int countTrue = 0;
            switch (operator) {
                case '&':
                    countTrue = leftTrue * rightTrue;
                    break;
                case '|':
                    countTrue = leftTrue * rightTrue + leftTrue * rightFalse + leftFalse * rightTrue;
                    break;
                case '^':
                    countTrue = (leftTrue * rightFalse) + (leftFalse * rightTrue);
                    break;
                default:
                    throw new RuntimeException("unexpected operator");
            }
            int countFalse = (leftTrue + leftFalse) * (rightTrue + rightFalse) - countTrue;
            total += value ? countTrue : countFalse;
        }
        return total;
    }

}
